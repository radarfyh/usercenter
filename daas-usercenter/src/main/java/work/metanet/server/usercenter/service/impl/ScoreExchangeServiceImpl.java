package work.metanet.server.usercenter.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.apache.commons.lang3.EnumUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.integration.redis.util.RedisLockRegistry;

import work.metanet.server.usercenter.repository.LogisticsRepository;
import work.metanet.server.usercenter.repository.UserScoreExchangeRepository;
import work.metanet.server.usercenter.repository.UserTargetPrizeRepository;
import work.metanet.server.usercenter.repository.UsersRepository;
import work.metanet.server.usercenter.service.ScoreExchangeService;
import work.metanet.server.usercenter.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.app.IAppService;
import work.metanet.api.app.vo.AppVo;
import work.metanet.api.prize.IPrizeService;
import work.metanet.api.prize.vo.PrizeVo;
import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.api.userScore.vo.UserScoreVo;
import work.metanet.api.userScoreExchange.protocol.ReqSaveUserScoreExchange;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchange;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchangeInfo.RespUserScoreExchangeInfo;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchangeList;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchangeList.RespUserScoreExchangeList;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.base.RespPaging;
import work.metanet.constant.ConstPrizeStatus;
import work.metanet.constant.ConstUserLogisticsStatus;
import work.metanet.constant.ConstUserScoreChangeType;
import work.metanet.constant.Constant;
import work.metanet.exception.MetanetException;
import work.metanet.server.usercenter.domain.UcScoreExchanges;
import work.metanet.server.usercenter.domain.UcTargetPrizes;
import work.metanet.server.usercenter.domain.UcUserLogistics;
import work.metanet.utils.CosUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 用户积分兑换
 * @Author Louis & Edison & W.B.
 * @DateTime 2020/06/29
 */
@Slf4j
@DubboService
public class ScoreExchangeServiceImpl implements ScoreExchangeService{

	@Autowired
	private UsersRepository userRepository;
	@DubboReference
	private IAppService appService;
	@Autowired
	private UserScoreExchangeRepository userScoreExchangeRepository;
	@DubboReference
	private IPrizeService prizeService;
	@Autowired
	private ScoreService userScoreService;
	@Autowired
	private UserTargetPrizeRepository userTargetPrizeRepository;
	@Autowired
    private RedisLockRegistry redisLockRegistry;
	@Autowired
	private CosUtil cosUtil;
	@Autowired
	private LogisticsRepository logisticsRepository;
	@Autowired
	private Constant constant;
	
	@GlobalTransactional
	@Override
	public void userScoreExchange(String userId, ReqUserScoreExchange req) throws Exception {
		PrizeVo prizeVo = prizeService.getPrizeVoByIdLock(req.getPrizeId());
		if(BeanUtil.isEmpty(prizeVo) || !prizeVo.getStatus()) 
			throw MetanetException.of().setMsg("商品不存在，请重新选择您要兑换的商品哦！");
		if(ConstPrizeStatus.DOWN.name().equals(prizeVo.getPrizeStatus())) throw MetanetException.of().setMsg("奖品已下架，请重新选择您要兑换的奖品哦！");
		if(prizeVo.getInventory() < 1) 
			throw MetanetException.of().setMsg("库存不足，请重新选择您要兑换的商品哦！");
		
		UserScoreVo userScore = userScoreService.initUserScore(userId);
		if(NumberUtil.isLess(userScore.getValue(), prizeVo.getScore())) throw MetanetException.of().setMsg("您的积分不足哦！赶紧加油学习吧^^");
		
		Optional<UcUsers> user = userRepository.findById(userId);
		if(!user.isPresent())
			throw MetanetException.of().setMsg("用户不存在");	
		AppVo appVo = appService.getAppByAppId(user.get().getAppId());
		
		UcScoreExchanges userScoreExchange = BeanUtil.copyProperties(req, UcScoreExchanges.class)
				.setChannelId(appVo.getChannelId())
				.setUserId(userId)
				.setPrizeName(prizeVo.getPrizeName())
				.setPrizeImg(prizeVo.getPrizeImg())
				.setScore(prizeVo.getScore())
				;
		
		//积分兑换
		userScoreExchangeRepository.save(userScoreExchange);
		
		//触发用户积分
		userScoreService.changeUserScore(userId
				, NumberUtil.mul(prizeVo.getScore(),-1)
				, ConstUserScoreChangeType.EXCHANGE.name()
				, userScoreExchange.getId()
				, StrUtil.concat(true, "兑换商品-",prizeVo.getPrizeName()),new Date());
		
		//删除用户订购
		userTargetPrizeRepository.delete(new UcTargetPrizes().setUserId(userId));
		
		UcUserLogistics logistics = BeanUtil.copyProperties(req, UcUserLogistics.class);
		logistics.setLogisticsStatus(ConstUserLogisticsStatus.PICKING.getVal());
		logisticsRepository.save(logistics);
		
		Lock lock = redisLockRegistry.obtain(prizeVo.getPrizeId());
		if(lock.tryLock(constant.getRedis_lock_timeout_seconds(),TimeUnit.SECONDS)) {
			try {
				//log.info("---我拿到了锁---:"+lock.toString());
				//扣减库存(并发处理)
				prizeService.updatePrizeInventory(prizeVo.getPrizeId(), -1);
			}finally {
				//log.info("---我释放锁了---:"+lock.toString());
				lock.unlock();
			}
		}else {
			log.info("---我等待了{}秒还未拿到锁---:{}",constant.getRedis_lock_timeout_seconds(),lock.toString());
    		throw MetanetException.of().setMsg("服务器繁忙！");
		}
	}
	
	@Override
	public RespUserScoreExchangeInfo userScoreExchangeInfo(String userScoreExchangeId) throws Exception {
		Optional<UcScoreExchanges> userScoreExchange = userScoreExchangeRepository.findById(userScoreExchangeId);
		if(userScoreExchange.isPresent()) {
			return BeanUtil.copyProperties(userScoreExchange, RespUserScoreExchangeInfo.class);
		}
		return null;
	}
	
	@Override
	public RespPaging<RespUserScoreExchangeList> userScoreExchangeList(ReqUserScoreExchangeList req) throws Exception {
		RespPaging<RespUserScoreExchangeList> respPaging = new RespPaging<RespUserScoreExchangeList>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespUserScoreExchangeList> dbList = userScoreExchangeRepository.userScoreExchangeList(req);
		BeanUtil.copyProperties(new PageInfo<RespUserScoreExchangeList>(dbList), respPaging);
		for (RespUserScoreExchangeList resp : respPaging.getList()) {
			resp.setPrizeImg(cosUtil.getAccessUrl(resp.getPrizeImg()));
		}
		return respPaging;
	}
	
	@Override
	public void saveUserScoreExchange(ReqSaveUserScoreExchange req) throws Exception {
		UcScoreExchanges userScoreExchange = new UcScoreExchanges()
				.setOrderNumber(req.getOrderNumber())
				;
		userScoreExchange.setId(req.getUserScoreExchangeId());
		userScoreExchange.setRemark(req.getRemark());
		userScoreExchangeRepository.save(userScoreExchange);

		UcUserLogistics logistics = BeanUtil.copyProperties(req, UcUserLogistics.class);
		if (EnumUtils.isValidEnum(ConstUserLogisticsStatus.class, req.getSendStatus())) {
			logistics.setLogisticsStatus(ConstUserLogisticsStatus.valueOf(req.getSendStatus()).getVal());
		}
		logistics.setCourierNumber(req.getCourierNumber());
		logistics.setSentTime(req.getSendTime());
		logisticsRepository.save(logistics);		
	}

	@Override
	public int save(UcScoreExchanges record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcScoreExchanges record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcScoreExchanges record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcScoreExchanges record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcScoreExchanges record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcScoreExchanges> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcScoreExchanges findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcScoreExchanges> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcScoreExchanges> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
