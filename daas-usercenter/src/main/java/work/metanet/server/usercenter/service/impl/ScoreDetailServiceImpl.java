package work.metanet.server.usercenter.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import work.metanet.server.usercenter.domain.UcScoreDetail;
import work.metanet.server.usercenter.repository.UserScoreDetailRepository;
import work.metanet.server.usercenter.service.ScoreDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.userScoreDetail.protocol.ReqAppUserScoreDetail;
import work.metanet.api.userScoreDetail.protocol.ReqAppUserScoreDetail.RespAppUserScoreDetail;
import work.metanet.api.userScoreDetail.protocol.ReqUserScoreDetailList;
import work.metanet.api.userScoreDetail.protocol.ReqUserScoreDetailList.RespUserScoreDetailList;
import work.metanet.base.RespPaging;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.constant.ConstUserScoreChangeType;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.EnumUtil;

@DubboService
public class ScoreDetailServiceImpl implements ScoreDetailService{

	@Autowired
	private UserScoreDetailRepository userScoreDetailRepository;
	
	@Override
	public RespPaging<RespAppUserScoreDetail> appUserScoreDetail(ReqAppUserScoreDetail req) throws Exception {
		RespPaging<RespAppUserScoreDetail> respPaging = new RespPaging<RespAppUserScoreDetail>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespAppUserScoreDetail> list = userScoreDetailRepository.appUserScoreDetail(req);
		BeanUtil.copyProperties(new PageInfo<RespAppUserScoreDetail>(list),respPaging);
		return respPaging;
	}
	
	@Override
	public RespPaging<RespUserScoreDetailList> userScoreDetailList(ReqUserScoreDetailList req) throws Exception {
		RespPaging<RespUserScoreDetailList> respPaging = new RespPaging<RespUserScoreDetailList>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespUserScoreDetailList> list = userScoreDetailRepository.userScoreDetailList(req);
		BeanUtil.copyProperties(new PageInfo<RespUserScoreDetailList>(list),respPaging);
		for (RespUserScoreDetailList respUserScoreDetailList : respPaging.getList()) {
			respUserScoreDetailList.setChangeType(EnumUtil.likeValueOf(ConstUserScoreChangeType.class, respUserScoreDetailList.getChangeType()).getText());
		}
		return respPaging;
	}

	@Override
	public int save(UcScoreDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcScoreDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcScoreDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcScoreDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcScoreDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcScoreDetail> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcScoreDetail findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcScoreDetail> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcScoreDetail> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
