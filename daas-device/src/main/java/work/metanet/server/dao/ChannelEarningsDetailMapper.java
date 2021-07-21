/**  
 * @Title: OrderMapper.java
 * @Description: TODO
 * @Author Louis & Edison & W.B.
 * @date 2018年3月28日
 */
package work.metanet.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import work.metanet.api.channelEarningsDetail.protocol.ReqChannelEarningsDetailList.RespChannelEarningsDetailList;
import work.metanet.model.ChannelEarningsDetail;

import tk.mybatis.mapper.common.Mapper;

public interface ChannelEarningsDetailMapper extends Mapper<ChannelEarningsDetail>{
	
	/**
	 * @Description: 渠道收益详情列表汇总
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/05
	 */
	Map<String, Object> channelEarningsDetailListSum(Map<String, Object> map);
	
	/**
	 * @Description: 渠道收益详情列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/04
	 */
	List<RespChannelEarningsDetailList> channelEarningsDetailList(Map<String, Object> map);
	
	@Select("select * from t_channel_earnings_detail where status=true and user_id=#{userId} and order_number=#{orderNumber}")
	ChannelEarningsDetail getChannelEarningsDetailOnly(@Param("userId")String userId,@Param("orderNumber")String orderNum);
	
}
