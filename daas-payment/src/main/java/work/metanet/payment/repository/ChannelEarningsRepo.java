package work.metanet.payment.repository;

import java.util.List;
import java.util.Map;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import work.metanet.api.channelEarnings.protocol.ReqChannelEarningsList.RespChannelEarningsList;
import work.metanet.model.ChannelEarnings;

public interface ChannelEarningsRepo extends JpaRepository<ChannelEarnings, String> {
	
	/**
	 * @Description: 渠道收益列表汇总
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/05
	 */
	@Query(value = "select\r\n"
			+ "			sum(dt.detailTotal) detailTotal,\r\n"
			+ "			sum(ce.order_pay_total_amount) orderPayTotalAmount,\r\n"
			+ "			sum(ce.original_earnings_total_amount) originalEarningsTotalAmount,\r\n"
			+ "			sum(ce.actual_earnings_total_amount) actualEarningsTotalAmount\r\n"
			+ "		from t_channel_earnings ce\r\n"
			+ "			left join t_channel ch on ch.channel_id=ce.channel_id\r\n"
			+ "			left join (select channel_earnings_id,count(1) detailTotal from t_channel_earnings_detail where status=true GROUP BY channel_earnings_id)dt on dt.channel_earnings_id=ce.channel_earnings_id\r\n"
			+ "		where 1=1\""
			+ "		and ce.`status`=true\r\n"
			+ "		<if test=\"channelId!=null and channelId!=''\">\r\n"
			+ "			and ce.channel_id=#{channelId}			\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"month!=null and month!=''\">\r\n"
			+ "			and ce.`month`=#{month}			\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"startTime!=null and startTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ce.create_time,'%Y%m%d')>=DATE_FORMAT(#{startTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"endTime!=null and endTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ce.create_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(#{endTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"remark!=null and remark!=''\">\r\n"
			+ "			and ce.remark like CONCAT('%',#{remark},'%')\r\n"
			+ "		</if>", nativeQuery = true)
	Map<String, Object> channelEarningsListSum(Map<String, Object> map);
	
	/**
	 * @Description: 渠道收益列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/03
	 */
	
	@Query(value = "select\r\n"
			+ "			ce.channel_earnings_id,\r\n"
			+ "			ch.channel_name,\r\n"
			+ "			ce.`month`,\r\n"
			+ "			ce.order_pay_total_amount,\r\n"
			+ "			ce.original_earnings_total_amount,\r\n"
			+ "			ce.actual_earnings_total_amount,\r\n"
			+ "			ce.remark,\r\n"
			+ "			dt.detailTotal,\r\n"
			+ "			DATE_FORMAT(ce.create_time,'%Y-%m-%d %H:%i:%s') create_time,\r\n"
			+ "			DATE_FORMAT(ce.update_time,'%Y-%m-%d %H:%i:%s') update_time\r\n"
			+ "		from t_channel_earnings ce\r\n"
			+ "			left join t_channel ch on ch.channel_id=ce.channel_id\r\n"
			+ "			left join (select channel_earnings_id,count(1) detailTotal from t_channel_earnings_detail where status=true GROUP BY channel_earnings_id)dt on dt.channel_earnings_id=ce.channel_earnings_id\r\n"
			+ "		where 1=1\r\n"
			+ "			<include refid=\"where_channelEarningsList\"/>\r\n"
			+ "		order by ce.`month` desc"			+ "		<if test=\"channelId!=null and channelId!=''\">\r\n"
			+ "			and ce.channel_id=#{channelId}			\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"month!=null and month!=''\">\r\n"
			+ "			and ce.`month`=#{month}			\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"startTime!=null and startTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ce.create_time,'%Y%m%d')>=DATE_FORMAT(#{startTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"endTime!=null and endTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ce.create_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(#{endTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"remark!=null and remark!=''\">\r\n"
			+ "			and ce.remark like CONCAT('%',#{remark},'%')\r\n"
			+ "		</if>", nativeQuery = true)

	List<RespChannelEarningsList> channelEarningsList(Map<String, Object> map);
	
	
	/**
	 * @Description: 获取某月渠道收益信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/08
	 */
	@Query(value = "select * from t_channel_earnings where status=true and month=#{month} and channel_id=#{channelId}", nativeQuery = true)
	ChannelEarnings getChannelEarnings(@Param("month")String month,@Param("channelId")String channelId);
	
}
