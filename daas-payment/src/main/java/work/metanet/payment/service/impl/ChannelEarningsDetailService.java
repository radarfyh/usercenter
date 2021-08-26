package work.metanet.payment.service.impl;


import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.channelEarningsDetail.IChannelEarningsDetailService;
import work.metanet.api.channelEarningsDetail.protocol.ReqChannelEarningsDetailList;
import work.metanet.api.channelEarningsDetail.protocol.ReqChannelEarningsDetailList.RespChannelEarningsDetailList;
import work.metanet.base.RespPaging;
import work.metanet.payment.repository.ChannelEarningsDetailRepo;
import cn.hutool.core.bean.BeanUtil;

@DubboService
@RefreshScope
public class ChannelEarningsDetailService implements IChannelEarningsDetailService{
	
	@Autowired
	private ChannelEarningsDetailRepo channelEarningsDetailRepo;
	
	@Override
	public RespPaging<RespChannelEarningsDetailList> channelEarningsDetailList(ReqChannelEarningsDetailList req) throws Exception {
		RespPaging<RespChannelEarningsDetailList> respPaging = new RespPaging<RespChannelEarningsDetailList>();
		Map<String, Object> reqMap = BeanUtil.beanToMap(req);
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespChannelEarningsDetailList> list = channelEarningsDetailRepo.channelEarningsDetailList(reqMap);
		BeanUtil.copyProperties(new PageInfo<RespChannelEarningsDetailList>(list), respPaging);
		Map<String, Object> mapSum = channelEarningsDetailRepo.channelEarningsDetailListSum(reqMap);
		respPaging.setExtra(mapSum);
		return respPaging;
	}
	
	
}
