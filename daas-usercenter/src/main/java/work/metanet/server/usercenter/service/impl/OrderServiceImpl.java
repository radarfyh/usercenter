package work.metanet.server.usercenter.service.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import work.metanet.server.usercenter.repository.UserTargetPrizeRepository;
import work.metanet.server.usercenter.service.OrderService;
import work.metanet.api.userTargetPrize.protocol.ReqSaveUserTargetPrize;
import work.metanet.api.userTargetPrize.protocol.ReqUserTargetPrizeInfo.RespUserTargetPrizeInfo;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.constant.SysConstants;
import work.metanet.server.usercenter.domain.UcTargetPrizes;
import work.metanet.utils.CosUtil;

import cn.hutool.core.bean.BeanUtil;

@DubboService
@RefreshScope
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserTargetPrizeRepository userTargetPrizeRepository;
	@Autowired
	private CosUtil cosUtil;
	
	@Override
	public void saveUserTargetProze(String userId, ReqSaveUserTargetPrize req) throws Exception {
		UcTargetPrizes userTargetPrize = userTargetPrizeRepository.userTargetPrize(userId);
		if(BeanUtil.isEmpty(userTargetPrize)) {
			userTargetPrize = new UcTargetPrizes();
			userTargetPrize.setUserId(userId).setPrizeId(req.getPrizeId());
			userTargetPrizeRepository.save(userTargetPrize);
		}else {
			userTargetPrize.setPrizeId(req.getPrizeId());
			userTargetPrizeRepository.save(userTargetPrize);
		}
	}
	
	@Override
	public RespUserTargetPrizeInfo userTargetPrizeInfo(String userId) throws Exception {
		RespUserTargetPrizeInfo resp = userTargetPrizeRepository.userTargetPrizesInfo(userId);
		if(BeanUtil.isNotEmpty(resp)) {
			resp.setPrizeImg(cosUtil.getAccessUrl(resp.getPrizeImg()));
		}
		return resp;
	}
	
	@Override
	public BigDecimal prizeCompletion(String userId) throws Exception {
		return userTargetPrizeRepository.prizeCompletion(userId);
	}

	@Override
	public int save(UcTargetPrizes record) {
		if(userTargetPrizeRepository.save(record) == null) {
			return SysConstants.FAILURE;
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public int add(UcTargetPrizes record) {
		if(userTargetPrizeRepository.save(record) == null) {
			return SysConstants.FAILURE;
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public int update(String id, UcTargetPrizes record) {
		if(!userTargetPrizeRepository.findById(id).isPresent()) {
			return SysConstants.FAILURE;
		}
		UcTargetPrizes obj = new UcTargetPrizes();
		BeanUtil.copyProperties(record, obj);
		obj.setId(id);
		if(userTargetPrizeRepository.save(obj) == null) {
			return SysConstants.FAILURE;
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public int update(UcTargetPrizes record) {
		if(userTargetPrizeRepository.save(record) == null) {
			return SysConstants.FAILURE;
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(UcTargetPrizes record) {
		userTargetPrizeRepository.delete(record);
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(String id) {
		userTargetPrizeRepository.deleteById(id);
		return SysConstants.SUCCUSS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int delete(List<UcTargetPrizes> records) {
		Iterator<UcTargetPrizes> ite = records.iterator();
		userTargetPrizeRepository.deleteInBatch((Iterable<UcTargetPrizes>) ite);
		return SysConstants.SUCCUSS;
	}

	@Override
	public UcTargetPrizes findById(String id) {
		Optional<UcTargetPrizes> prize = userTargetPrizeRepository.findById(id);
		if (prize.isPresent()) {
			return prize.get();
		}
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		return null;
	}

	@Override
	public Iterable<UcTargetPrizes> findAllSort(Sort sort) {

		return null;
	}

	@Override
	public Page<UcTargetPrizes> findAll(Pageable page) {

		return null;
	}
}
