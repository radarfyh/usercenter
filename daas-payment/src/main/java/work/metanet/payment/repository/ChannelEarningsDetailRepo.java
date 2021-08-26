package work.metanet.payment.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import work.metanet.api.channelEarningsDetail.protocol.ReqChannelEarningsDetailList.RespChannelEarningsDetailList;
import work.metanet.model.ChannelEarningsDetail;


public interface ChannelEarningsDetailRepo extends JpaRepository<ChannelEarningsDetail, String> {
	
	/**
	 * @Description: 渠道收益详情列表汇总
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/05
	 */
	@Query(value = "select\r\n"
			+ "			sum(ced.order_pay_amount) orderPayAmount,\r\n"
			+ "			sum(ced.original_earnings_amount) originalEarningsAmount,\r\n"
			+ "			sum(ced.actual_earnings_amount) actualEarningsAmount\r\n"
			+ "		from t_channel_earnings_detail ced\r\n"
			+ "			join t_channel_earnings ce on ce.status=true and ce.channel_earnings_id=ced.channel_earnings_id\r\n"
			+ "			left join t_third_business tb on tb.third_business_id=ced.third_business_id\r\n"
			+ "			left join t_channel ch on ch.channel_id=ce.channel_id\r\n"
			+ "			left join t_user u on u.user_id=ced.user_id\r\n"
			+ "			left join t_app ap on ap.app_id=u.app_id\r\n"
			+ "		where 1=1"
			+ "		and ce.`status`=true\r\n"
			+ "		and ced.channel_earnings_id=#{channelEarningsId}\r\n"
			+ "		<if test=\"appId!=null and appId!=''\">\r\n"
			+ "			and ap.app_id=#{appId}\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"thirdBusinessId!=null and thirdBusinessId!=''\">\r\n"
			+ "			and ced.third_business_id=#{thirdBusinessId}\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"username!=null and username!=''\">\r\n"
			+ "			and u.username=#{username}			\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"orderNumber!=null and orderNumber!=''\">\r\n"
			+ "			and ced.order_number=#{orderNumber}			\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"orderPayStartTime!=null and orderPayStartTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ced.order_pay_time,'%Y%m%d')>=DATE_FORMAT(#{orderPayStartTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"orderPayEndTime!=null and orderPayEndTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ced.order_pay_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(#{orderPayStartTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"startTime!=null and startTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ced.create_time,'%Y%m%d')>=DATE_FORMAT(#{startTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"endTime!=null and endTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ced.create_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(#{endTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"remark!=null and remark!=''\">\r\n"
			+ "			and ced.remark like CONCAT('%',#{remark},'%')\r\n"
			+ "		</if>", nativeQuery = true)
	Map<String, Object> channelEarningsDetailListSum(Map<String, Object> map);
	
	/**
	 * @Description: 渠道收益详情列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/04
	 */
	@Query(value = "select\r\n"
			+ "			ced.channel_earnings_detail_id,\r\n"
			+ "			ch.channel_name,\r\n"
			+ "			ap.app_name,\r\n"
			+ "			ce.`month`,\r\n"
			+ "			tb.third_business_name,\r\n"
			+ "			u.username,\r\n"
			+ "			ced.order_number,\r\n"
			+ "			ced.order_pay_amount,\r\n"
			+ "			ced.original_earnings_amount,\r\n"
			+ "			ced.settlement_ratio,\r\n"
			+ "			ced.actual_earnings_amount,\r\n"
			+ "			ced.remark,\r\n"
			+ "			DATE_FORMAT(ced.order_pay_time,'%Y-%m-%d %H:%i:%s') order_pay_time,\r\n"
			+ "			DATE_FORMAT(ce.create_time,'%Y-%m-%d %H:%i:%s') create_time,\r\n"
			+ "			DATE_FORMAT(ce.update_time,'%Y-%m-%d %H:%i:%s') update_time\r\n"
			+ "		from t_channel_earnings_detail ced\r\n"
			+ "			join t_channel_earnings ce on ce.status=true and ce.channel_earnings_id=ced.channel_earnings_id\r\n"
			+ "			left join t_third_business tb on tb.third_business_id=ced.third_business_id\r\n"
			+ "			left join t_channel ch on ch.channel_id=ce.channel_id\r\n"
			+ "			left join t_user u on u.user_id=ced.user_id\r\n"
			+ "			left join t_app ap on ap.app_id=u.app_id\r\n"
			+ "		where 1=1\r\n"
			+ "		and ce.`status`=true\r\n"
			+ "		and ced.channel_earnings_id=#{channelEarningsId}\r\n"
			+ "		<if test=\"appId!=null and appId!=''\">\r\n"
			+ "			and ap.app_id=#{appId}\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"thirdBusinessId!=null and thirdBusinessId!=''\">\r\n"
			+ "			and ced.third_business_id=#{thirdBusinessId}\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"username!=null and username!=''\">\r\n"
			+ "			and u.username=#{username}			\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"orderNumber!=null and orderNumber!=''\">\r\n"
			+ "			and ced.order_number=#{orderNumber}			\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"orderPayStartTime!=null and orderPayStartTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ced.order_pay_time,'%Y%m%d')>=DATE_FORMAT(#{orderPayStartTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"orderPayEndTime!=null and orderPayEndTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ced.order_pay_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(#{orderPayStartTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"startTime!=null and startTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ced.create_time,'%Y%m%d')>=DATE_FORMAT(#{startTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"endTime!=null and endTime!=''\">\r\n"
			+ "			and DATE_FORMAT(ced.create_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(#{endTime},'%Y%m%d')\r\n"
			+ "		</if>\r\n"
			+ "		<if test=\"remark!=null and remark!=''\">\r\n"
			+ "			and ced.remark like CONCAT('%',#{remark},'%')\r\n"
			+ "		</if>"
			+ "		order by ced.order_pay_time desc,ced.create_time desc", nativeQuery = true)
	List<RespChannelEarningsDetailList> channelEarningsDetailList(Map<String, Object> map);
	
	@Query(value = "select * from t_channel_earnings_detail where status=true and user_id=#{userId} and order_number=#{orderNumber}", nativeQuery = true)
	ChannelEarningsDetail getChannelEarningsDetailOnly(@Param("userId")String userId,@Param("orderNumber")String orderNum);
	
}
