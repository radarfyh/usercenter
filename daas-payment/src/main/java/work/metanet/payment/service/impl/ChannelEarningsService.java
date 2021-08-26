package work.metanet.payment.service.impl;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.channelEarnings.IChannelEarningsService;
import work.metanet.api.channelEarnings.protocol.ReqChannelEarningsList;
import work.metanet.api.channelEarnings.protocol.ReqChannelEarningsList.RespChannelEarningsList;
import work.metanet.api.channelEarnings.protocol.ReqImportChannelEarnings;

import work.metanet.base.RespPaging;
import work.metanet.exception.MetanetException;
import work.metanet.model.ChannelEarnings;
import work.metanet.model.ChannelEarningsDetail;
import work.metanet.payment.repository.ChannelEarningsDetailRepo;
import work.metanet.payment.repository.ChannelEarningsRepo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;

@DubboService
@RefreshScope
public class ChannelEarningsService implements IChannelEarningsService{
	
	@Autowired
	private ChannelEarningsRepo channelEarningsRepo;
	@Autowired
	private ChannelEarningsDetailRepo channelEarningsDetailRepo;
	
	@Override
	public RespPaging<RespChannelEarningsList> channelEarningsList(ReqChannelEarningsList req) throws Exception {
		RespPaging<RespChannelEarningsList> respPaging = new RespPaging<RespChannelEarningsList>();
		Map<String, Object> reqMap = BeanUtil.beanToMap(req);
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespChannelEarningsList> list = channelEarningsRepo.channelEarningsList(reqMap);
		BeanUtil.copyProperties(new PageInfo<RespChannelEarningsList>(list), respPaging);
		Map<String, Object> mapSum = channelEarningsRepo.channelEarningsListSum(reqMap);
		respPaging.setExtra(mapSum);
		return respPaging;
	}
	
	@Override
	@Transactional
	public void importChannelEarnings(ReqImportChannelEarnings req
			, String thirdBusinessId, String channelId, Double settlementRatio) throws Exception {
//		ThirdBusiness thirdBusiness = thirdBusinessMapper.getThirdBusinessByCode(req.getThirdBusinessCode());
//		if(BeanUtil.isEmpty(thirdBusiness)) throw MetanetException.of().setMsg("第三方内容商不存在");
		
		ChannelEarningsDetail channelEarningsDetail = channelEarningsDetailRepo.getChannelEarningsDetailOnly(req.getUserId(), req.getOrderNumber());
		if(BeanUtil.isNotEmpty(channelEarningsDetail)) throw MetanetException.of().setMsg("收益明细记录已存在");
		
		ChannelEarnings channelEarnings = channelEarningsRepo.getChannelEarnings(req.getMonth(), channelId);
		
		/**更新或新增主表*/
		if(BeanUtil.isEmpty(channelEarnings)) {
			channelEarnings = new ChannelEarnings()
					.setChannelEarningsId(IdUtil.fastSimpleUUID())
					.setChannelId(channelId)
					.setMonth(req.getMonth())
					.setOrderPayTotalAmount(NumberUtil.round(req.getOrderPayAmount(),2, RoundingMode.FLOOR))
					.setOriginalEarningsTotalAmount(NumberUtil.round(req.getOriginalEarningsAmount(),2, RoundingMode.FLOOR))
					.setActualEarningsTotalAmount(NumberUtil.round(NumberUtil.mul(req.getOriginalEarningsAmount(),settlementRatio/100),2, RoundingMode.FLOOR))
					;
			channelEarningsRepo.save(channelEarnings);
		}else {
			channelEarnings
			.setOrderPayTotalAmount(NumberUtil.round(NumberUtil.add(channelEarnings.getOrderPayTotalAmount(),req.getOrderPayAmount()),2, RoundingMode.FLOOR))
			.setOriginalEarningsTotalAmount(NumberUtil.round(NumberUtil.add(channelEarnings.getOriginalEarningsTotalAmount(),req.getOriginalEarningsAmount()),2, RoundingMode.FLOOR))
			.setActualEarningsTotalAmount(NumberUtil.round(NumberUtil.add(channelEarnings.getActualEarningsTotalAmount(),NumberUtil.mul(req.getOriginalEarningsAmount(),settlementRatio/100)),2, RoundingMode.FLOOR))
			;
			channelEarningsRepo.save(channelEarnings);
		}
		
		/**新增明细表*/
		channelEarningsDetail = new ChannelEarningsDetail()
				.setChannelEarningsDetailId(IdUtil.fastSimpleUUID())
				.setChannelEarningsId(channelEarnings.getChannelEarningsId())
				.setThirdBusinessId(thirdBusinessId)
				.setUserId(req.getUserId())
				.setOrderNumber(req.getOrderNumber())
				.setOrderPayTime(DateUtil.parse(req.getOrderPayTime()))
				.setOrderPayAmount(NumberUtil.round(req.getOrderPayAmount(),2, RoundingMode.FLOOR))
				.setOriginalEarningsAmount(NumberUtil.round(req.getOriginalEarningsAmount(),2, RoundingMode.FLOOR))
				.setSettlementRatio(settlementRatio)
				.setActualEarningsAmount(NumberUtil.round(NumberUtil.mul(req.getOriginalEarningsAmount(),settlementRatio/100),2, RoundingMode.FLOOR))
				;
		channelEarningsDetailRepo.save(channelEarningsDetail);
		
	}
	
	public static void main(String[] args) {
		System.out.println(NumberUtil.round(BigDecimal.valueOf(1.11), 2, RoundingMode.FLOOR));
	}
	
}
