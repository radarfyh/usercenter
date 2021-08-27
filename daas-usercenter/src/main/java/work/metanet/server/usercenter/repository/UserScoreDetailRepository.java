package work.metanet.server.usercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import work.metanet.api.userScoreDetail.protocol.ReqAppUserScoreDetail;
import work.metanet.api.userScoreDetail.protocol.ReqAppUserScoreDetail.RespAppUserScoreDetail;
import work.metanet.api.userScoreDetail.protocol.ReqUserScoreDetailList;
import work.metanet.api.userScoreDetail.protocol.ReqUserScoreDetailList.RespUserScoreDetailList;
import work.metanet.server.usercenter.domain.UcScoreDetail;

@Repository
public interface UserScoreDetailRepository extends JpaRepository<UcScoreDetail, String> {
	
	/**
	 * @Description: 用户积分明细
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/02
	 */
	@Query(value = "SELECT"
			+ "			DATE_FORMAT(usd.create_time,'%Y-%m-%d %H:%i:%s') create_time,"
			+ "			usd.change_value,"
			+ "			usd.after_value,"
			+ "			usd.remark"
			+ "		FROM uc_score_detail usd"
			+ "		join uc_user_scores us "
			+ "			on us.id=usd.user_score_id"
			+ "		WHERE usd.status=true"
			+ "			and us.user_id=:req.userId"
			+ "		  if(:req.date !=null and :req.date !='', "
			+ "         and DATE_FORMAT(usd.create_time,'%Y%m')=:req.date, and 1=1)"
			+ "	      if(:req.changeType !=null and :req.changeType !='', "
			+ "         and usd.change_type=:req.changeType, and 1=1)"
			+ "		ORDER BY usd.create_time desc", nativeQuery = true)
	List<RespAppUserScoreDetail> appUserScoreDetail(@Param("req")ReqAppUserScoreDetail req);
	
	/**
	 * @Description: 用户积分明细列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/08
	 */
	@Query(value = "select"
			+ "			usd.id,"
			+ "			usd.change_type,"
			+ "			usd.change_value,"
			+ "			usd.after_value,"
			+ "			usd.remark,"
			+ "			DATE_FORMAT(usd.create_time,'%Y-%m-%d %H:%i:%s') create_time,"
			+ "			DATE_FORMAT(usd.update_time,'%Y-%m-%d %H:%i:%s') update_time"
			+ "		from uc_score_detail usd"
			+ "		where usd.status=true"
			+ "		    and usd.user_score_id=:req.userScoreId"
			+ "		if(:req.changeType !=null and :req.changeType !='', "
			+ "			and usd.change_type=:req.changeType, and 1=1) "
			+ "		if(:req.startTime !=null and :req.startTime !='', "
			+ "			and DATE_FORMAT(usd.create_time,'%Y%m%d')<![CDATA[>=]]>DATE_FORMAT(:req.startTime,'%Y%m%d'), and 1=1) "
			+ "		if(:req.endTime !=null and :req.endTime !='', "
			+ "			and DATE_FORMAT(usd.create_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(:req.endTime,'%Y%m%d'), and 1=1) "
			+ "		if(:req.remark !=null and :req.remark !='', "
			+ "			and usd.remark like CONCAT('%',:req.remark,'%'), and 1=1) "
			+ "		order by usd.create_time desc", nativeQuery = true)
	List<RespUserScoreDetailList> userScoreDetailList(@Param("req")ReqUserScoreDetailList req);
	
}
