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

import work.metanet.api.channelEarnings.protocol.ReqChannelEarningsList.RespChannelEarningsList;
import work.metanet.model.ChannelEarnings;

import tk.mybatis.mapper.common.Mapper;

public interface ChannelEarningsMapper extends Mapper<ChannelEarnings>{
	
	/**
	 * @Description: 渠道收益列表汇总
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/05
	 */
	Map<String, Object> channelEarningsListSum(Map<String, Object> map);
	
	/**
	 * @Description: 渠道收益列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/03
	 */
	List<RespChannelEarningsList> channelEarningsList(Map<String, Object> map);
	
	
	/**
	 * @Description: 获取某月渠道收益信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/08
	 */
	@Select("select * from t_channel_earnings where status=true and month=#{month} and channel_id=#{channelId}")
	ChannelEarnings getChannelEarnings(@Param("month")String month,@Param("channelId")String channelId);
	
}
