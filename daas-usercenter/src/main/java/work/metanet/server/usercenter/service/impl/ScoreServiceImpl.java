package work.metanet.server.usercenter.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import work.metanet.server.usercenter.repository.UserScoreDetailRepository;
import work.metanet.server.usercenter.repository.UserScoreRepository;
import work.metanet.server.usercenter.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.userScore.protocol.ReqLearningChangeUserScore;
import work.metanet.api.userScore.protocol.ReqUserScoreList;
import work.metanet.api.userScore.protocol.ReqUserScoreList.RespUserScoreList;
import work.metanet.api.userScore.vo.UserScoreVo;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.base.RespPaging;
import work.metanet.constant.ConstCacheKey;
import work.metanet.constant.ConstUserScoreChangeType;
import work.metanet.constant.Constant;
import work.metanet.exception.MetanetException;
import work.metanet.server.usercenter.domain.UcUserScores;
import work.metanet.server.usercenter.domain.UcScoreDetail;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DubboService
public class ScoreServiceImpl implements ScoreService{

	@Autowired
	private UserScoreRepository userScoreRepository;
	@Autowired
	private UserScoreDetailRepository userScoreDetailRepository;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private Constant constant;
	
	@Override
	public UserScoreVo initUserScore(String userId) throws Exception {
		UcUserScores userScore = userScoreRepository.getUserScore(userId);
		if(BeanUtil.isEmpty(userScore)) {
			userScore = new UcUserScores().setUserId(userId).setValue(BigDecimal.valueOf(0));
			userScoreRepository.save(userScore);
		}
		return BeanUtil.copyProperties(userScore, UserScoreVo.class);
	}
	
	@Transactional
	@Override
	public void changeUserScore(String userId, BigDecimal changeValue, String changeType, String joinId, String remark, Date createTime) throws Exception {
		UserScoreVo userScoreVo = this.initUserScore(userId);
		UcScoreDetail userScoreDetail = new UcScoreDetail()
				.setUserScoreId(userScoreVo.getUserScoreId())
				.setChangeType(changeType)
				.setChangeValue(changeValue)
				.setAfterValue(NumberUtil.add(userScoreVo.getValue(),changeValue))
				.setJoinId(joinId);

		userScoreDetail.setRemark(remark);
		userScoreDetail.setCreateTime(createTime);
		
		userScoreDetailRepository.save(userScoreDetail);
		UcUserScores userScore = BeanUtil.copyProperties(userScoreVo, UcUserScores.class).setValue(userScoreDetail.getAfterValue());
		userScoreRepository.save(userScore);
	}
	
	@Transactional
	@Override
	public void learningChangeUserScore(String userId, ReqLearningChangeUserScore req) throws Exception {
		String nowTime = DateUtil.now();
		ConstCacheKey constCacheKey = ConstCacheKey.USER_SCORE_EDU;
		String cacheKey = constCacheKey.cacheKey(DateUtil.formatDate(DateUtil.date()),userId);
		
		//取出之前调用的学习时长信息
		ReqLearningChangeUserScore beforCall  = null;
		if(stringRedisTemplate.hasKey(cacheKey)) {
			beforCall = JSONUtil.toBean(stringRedisTemplate.opsForValue().get(cacheKey), ReqLearningChangeUserScore.class);			
		}else {
			beforCall = new ReqLearningChangeUserScore().setCallTime(nowTime).setLearningMinutes(0L).setDaySumScore(BigDecimal.valueOf(0));
			LearningMinutesConvertScore(userId, nowTime, beforCall, req);
			return;
		}
		
		//日累计积分上限
		if(NumberUtil.compare(beforCall.getDaySumScore().intValue(),constant.getDay_max_convert_score().intValue())>=0) throw MetanetException.of().setMsg("日累计积分已达上限");
		
		//前后调用时间间隔(分钟)
		Long betweenMinutes = DateUtil.between(DateUtil.parse(beforCall.getCallTime()), DateUtil.parse(nowTime), DateUnit.MINUTE,false);
		if(req.getLearningMinutes()>0 && req.getLearningMinutes()<=betweenMinutes) {
			LearningMinutesConvertScore(userId, nowTime, beforCall, req);
			return;
		}
		log.info("-----------start");
		log.info("---learningMinutes:"+req.getLearningMinutes());
		log.info("---betweenMinutes:---"+betweenMinutes);
		log.info("-----------end");
		throw MetanetException.of().setMsg("违规触发学习积分");
	}
	
	private void LearningMinutesConvertScore(String userId, String nowTime, ReqLearningChangeUserScore beforCall, ReqLearningChangeUserScore req) throws Exception{
		ConstCacheKey constCacheKey = ConstCacheKey.USER_SCORE_EDU;
		String cacheKey = constCacheKey.cacheKey(DateUtil.formatDate(DateUtil.date()),userId);
		Long sumLearningMinutes = beforCall.getLearningMinutes() + req.getLearningMinutes();
		Long overflowLearningMinutes = sumLearningMinutes % constant.getLearningMinutes_convert_score();
		BigDecimal score = Convert.toBigDecimal(sumLearningMinutes / constant.getLearningMinutes_convert_score());
		
		//计算积分
		if(score.intValue()>0) {
			changeUserScore(userId, score, ConstUserScoreChangeType.EDU.name(), null, "学习积分", DateUtil.parse(nowTime));
		}
		
		//溢出保留
		ReqLearningChangeUserScore currentCall = new ReqLearningChangeUserScore()
				.setCallTime(nowTime)
				.setLearningMinutes(overflowLearningMinutes)
				.setDaySumScore(NumberUtil.add(score,beforCall.getDaySumScore()));
		stringRedisTemplate.opsForValue().set(cacheKey, JSONUtil.toJsonStr(currentCall), constCacheKey.getExpire(), TimeUnit.SECONDS);
	}
	
	@Override
	public RespPaging<RespUserScoreList> userScoreList(ReqUserScoreList req) throws Exception {
		RespPaging<RespUserScoreList> respPaging = new RespPaging<RespUserScoreList>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespUserScoreList> dbUsers = userScoreRepository.userScoreList(req);
		BeanUtil.copyProperties(new PageInfo<RespUserScoreList>(dbUsers), respPaging);
		Map<String, Object> mapSum = userScoreRepository.userScoreListSum(req);
		respPaging.setExtra(mapSum);
		return respPaging;
	}

	@Override
	public int save(UcUserScores record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcUserScores record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcUserScores record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcUserScores record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcUserScores record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcUserScores> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcUserScores findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcUserScores> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcUserScores> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
