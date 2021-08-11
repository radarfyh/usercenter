package work.metanet.server.service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.channelEarnings.IChannelEarningsService;
import work.metanet.api.channelEarnings.protocol.ReqChannelEarningsList;
import work.metanet.api.channelEarnings.protocol.ReqChannelEarningsList.RespChannelEarningsList;
import work.metanet.api.channelEarnings.protocol.ReqImportChannelEarnings;
import work.metanet.api.user.IUserService;
import work.metanet.api.user.protocol.ReqUserInfo.RespUserInfo;
import work.metanet.base.RespPaging;
import work.metanet.exception.MetanetException;
import work.metanet.model.App;
import work.metanet.model.AppEarningsSetting;
import work.metanet.model.ChannelEarnings;
import work.metanet.model.ChannelEarningsDetail;
import work.metanet.model.ThirdBusiness;
import work.metanet.server.dao.AppEarningsSettingMapper;
import work.metanet.server.dao.AppMapper;
import work.metanet.server.dao.ChannelEarningsDetailMapper;
import work.metanet.server.dao.ChannelEarningsMapper;
import work.metanet.server.dao.ThirdBusinessMapper;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;

@DubboService
public class ChannelEarningsService implements IChannelEarningsService{
	
	@Autowired
	private ChannelEarningsMapper channelEarningsMapper;
	@Autowired
	private ChannelEarningsDetailMapper channelEarningsDetailMapper;
	@Autowired
	private ThirdBusinessMapper thirdBusinessMapper;
	@DubboReference
	private IUserService userService;
	@Autowired
	private AppMapper appMapper;
	@Autowired
	private AppEarningsSettingMapper appEarningsSettingMapper;
	
	@Override
	public RespPaging<RespChannelEarningsList> channelEarningsList(ReqChannelEarningsList req) throws Exception {
		RespPaging<RespChannelEarningsList> respPaging = new RespPaging<RespChannelEarningsList>();
		Map<String, Object> reqMap = BeanUtil.beanToMap(req);
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespChannelEarningsList> list = channelEarningsMapper.channelEarningsList(reqMap);
		BeanUtil.copyProperties(new PageInfo<RespChannelEarningsList>(list), respPaging);
		Map<String, Object> mapSum = channelEarningsMapper.channelEarningsListSum(reqMap);
		respPaging.setExtra(mapSum);
		return respPaging;
	}
	
	@Override
	@Transactional
	public void importChannelEarnings(ReqImportChannelEarnings req) throws Exception {
		ThirdBusiness thirdBusiness = thirdBusinessMapper.getThirdBusinessByCode(req.getThirdBusinessCode());
		if(BeanUtil.isEmpty(thirdBusiness)) throw MetanetException.of().setMsg("第三方内容商不存在");
		
		ChannelEarningsDetail channelEarningsDetail = channelEarningsDetailMapper.getChannelEarningsDetailOnly(req.getUserId(), req.getOrderNumber());
		if(BeanUtil.isNotEmpty(channelEarningsDetail)) throw MetanetException.of().setMsg("收益明细记录已存在");
		
		RespUserInfo userInfo = userService.userInfo(req.getUserId());
		if(BeanUtil.isEmpty(userInfo)) throw MetanetException.of().setMsg("用户不存在");
		
		App app = appMapper.selectByPrimaryKey(userInfo.getAppId());
		if(BeanUtil.isEmpty(app)) throw MetanetException.of().setMsg("产品不存在");
		
		AppEarningsSetting appEarningsSetting = appEarningsSettingMapper.getAppEarningsSetting(app.getAppId(), thirdBusiness.getThirdBusinessId());
		if(BeanUtil.isEmpty(appEarningsSetting)) throw MetanetException.of().setMsg("产品【"+app.getAppName()+"】收益信息未设置");
		
		ChannelEarnings channelEarnings = channelEarningsMapper.getChannelEarnings(req.getMonth(), app.getChannelId());
		
		/**更新或新增主表*/
		if(BeanUtil.isEmpty(channelEarnings)) {
			channelEarnings = new ChannelEarnings()
					.setChannelEarningsId(IdUtil.fastSimpleUUID())
					.setChannelId(app.getChannelId())
					.setMonth(req.getMonth())
					.setOrderPayTotalAmount(NumberUtil.round(req.getOrderPayAmount(),2, RoundingMode.FLOOR))
					.setOriginalEarningsTotalAmount(NumberUtil.round(req.getOriginalEarningsAmount(),2, RoundingMode.FLOOR))
					.setActualEarningsTotalAmount(NumberUtil.round(NumberUtil.mul(req.getOriginalEarningsAmount(),appEarningsSetting.getSettlementRatio()/100),2, RoundingMode.FLOOR))
					;
			channelEarningsMapper.insertSelective(channelEarnings);
		}else {
			channelEarnings
			.setOrderPayTotalAmount(NumberUtil.round(NumberUtil.add(channelEarnings.getOrderPayTotalAmount(),req.getOrderPayAmount()),2, RoundingMode.FLOOR))
			.setOriginalEarningsTotalAmount(NumberUtil.round(NumberUtil.add(channelEarnings.getOriginalEarningsTotalAmount(),req.getOriginalEarningsAmount()),2, RoundingMode.FLOOR))
			.setActualEarningsTotalAmount(NumberUtil.round(NumberUtil.add(channelEarnings.getActualEarningsTotalAmount(),NumberUtil.mul(req.getOriginalEarningsAmount(),appEarningsSetting.getSettlementRatio()/100)),2, RoundingMode.FLOOR))
			;
			channelEarningsMapper.updateByPrimaryKeySelective(channelEarnings);
		}
		
		/**新增明细表*/
		channelEarningsDetail = new ChannelEarningsDetail()
				.setChannelEarningsDetailId(IdUtil.fastSimpleUUID())
				.setChannelEarningsId(channelEarnings.getChannelEarningsId())
				.setThirdBusinessId(thirdBusiness.getThirdBusinessId())
				.setUserId(req.getUserId())
				.setOrderNumber(req.getOrderNumber())
				.setOrderPayTime(DateUtil.parse(req.getOrderPayTime()))
				.setOrderPayAmount(NumberUtil.round(req.getOrderPayAmount(),2, RoundingMode.FLOOR))
				.setOriginalEarningsAmount(NumberUtil.round(req.getOriginalEarningsAmount(),2, RoundingMode.FLOOR))
				.setSettlementRatio(appEarningsSetting.getSettlementRatio())
				.setActualEarningsAmount(NumberUtil.round(NumberUtil.mul(req.getOriginalEarningsAmount(),appEarningsSetting.getSettlementRatio()/100),2, RoundingMode.FLOOR))
				;
		channelEarningsDetailMapper.insertSelective(channelEarningsDetail);
		
	}
	
	public static void main(String[] args) {
		System.out.println(NumberUtil.round(BigDecimal.valueOf(1.11), 2, RoundingMode.FLOOR));
	}
	
}
