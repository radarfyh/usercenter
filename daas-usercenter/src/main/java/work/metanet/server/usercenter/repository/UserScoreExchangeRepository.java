package work.metanet.server.usercenter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchangeList;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchangeList.RespUserScoreExchangeList;
import work.metanet.server.usercenter.domain.UcScoreExchanges;

@Repository
public interface UserScoreExchangeRepository extends JpaRepository<UcScoreExchanges, String> {

	@Query(value = "select se.*, ua.phone from uc_score_exchanges se "
			+ "		left join uc_user_logistics ul on ul.id=ul.logistics_id"
			+ "		left join uc_users u on u.id=ul.consignee_id"
			+ "		left join uc_user_addresses ua on ua.user_id=u.id"
			+ "		where  se.status=true"
			+ "		if(:req.channelId !=null and :req.channelId !='', "
			+ "			and se.channel_id=:req.channelId, and 1=1) "
			+ "		if(:req.orderNumber !=null and :req.orderNumber !='', "
			+ "			and se.order_number=:req.orderNumber, and 1=1) "
			+ "		if(:req.phone !=null and :req.phone !='', "
			+ "			and ua.phone like CONCAT('%',:req.phone,'%'), and 1=1) "
			+ "		if(:req.courierNumber !=null and :req.courierNumber !='', "
			+ "			and ul.courier_number like CONCAT('%',:req.courierNumber,'%'), and 1=1) "
			+ "		if(:req.sendStatus !=null and :req.sendStatus !='', "
			+ "			and ul.logistics_status=:req.sendStatus, and 1=1) "
			+ "		if(:req.startTime !=null and :req.startTime !='', "
			+ "			and DATE_FORMAT(se.create_time,'%Y%m%d')<![CDATA[>=]]>DATE_FORMAT(:req.startTime,'%Y%m%d'), and 1=1) "
			+ "		if(:req.endTime !=null and :req.endTime !='', "
			+ "			and DATE_FORMAT(se.create_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(:req.endTime,'%Y%m%d'), and 1=1) "
			+ "		if(:req.remark !=null and :req.remark !='', "
			+ "			and se.remark like CONCAT('%',:req.remark,'%'), and 1=1) "
			+ "		order by se.order_number desc", nativeQuery = true)
	List<RespUserScoreExchangeList> userScoreExchangeList(@Param("req")ReqUserScoreExchangeList req);

	/**
	 * @param userScoreExchangeId
	 * @return
	 */
	Optional<UcScoreExchanges> findById(String id);
	
}
