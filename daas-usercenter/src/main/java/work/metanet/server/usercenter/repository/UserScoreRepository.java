package work.metanet.server.usercenter.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import work.metanet.api.userScore.protocol.ReqUserScoreList;
import work.metanet.api.userScore.protocol.ReqUserScoreList.RespUserScoreList;
import work.metanet.server.usercenter.domain.UcUserScores;

@Repository
public interface UserScoreRepository extends JpaRepository<UcUserScores, String> {
	
	@Query(value = "select * from uc_user_scores where user_id=:userId", nativeQuery = true)
	UcUserScores getUserScore(@Param("userId")String userId);
	
	@Query(value = "select"
			+ "			us.user_score_id,"
			+ "			u.username,"
			+ "			u.phone,"
			+ "			IFNULL(us.`value`,0) score,"
			+ "			DATE_FORMAT(us.create_time,'%Y-%m-%d %H:%i:%s') create_time,"
			+ "			DATE_FORMAT(us.update_time,'%Y-%m-%d %H:%i:%s') update_time"
			+ "		from uc_users u"
			+ "			left join uc_user_scores us on us.user_id=u.user_id"
			+ "		where u.status=true"
			+ "		  if(:req.user !=null and :req.user !='', "
			+ "			and ("
			+ "				u.user_id like CONCAT('%',:req.user,'%') or"
			+ "				u.phone like CONCAT('%',:req.user,'%') or"
			+ "				u.email like CONCAT('%',:req.user,'%')"
			+ "				), and 1=1)"
			+ "		  if(:req.appId !=null and :req.appId !='', "
			+ "         and u.app_id=:req.appId, and 1=1)"
			+ "		  if(:req.startTime !=null and :req.startTime !='', "
			+ "			and DATE_FORMAT(us.create_time,'%Y%m%d')<![CDATA[>=]]>DATE_FORMAT(:req.startTime,'%Y%m%d'), and 1=1) "
			+ "		  if(:req.endTime !=null and :req.endTime !='', "
			+ "			and DATE_FORMAT(us.create_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(:req.endTime,'%Y%m%d'), and 1=1) "
			+ "		  if(:req.remark !=null and :req.remark !='', "
			+ "			and us.remark like CONCAT('%',:req.remark,'%'), and 1=1) "
			+ "		order by score desc", nativeQuery = true)
	List<RespUserScoreList> userScoreList(@Param("req")ReqUserScoreList req);
	
	@Query(value = "select"
			+ "			SUM(IFNULL(us.`value`,0)) score"
			+ "		from uc_users u"
			+ "			left join uc_user_scores us on us.user_id=u.user_id"
			+ "		where u.status=true"
			+ "		  if(:req.user !=null and :req.user !='', "
			+ "			and ("
			+ "				u.user_id like CONCAT('%',:req.user,'%') or"
			+ "				u.phone like CONCAT('%',:req.user,'%') or"
			+ "				u.email like CONCAT('%',:req.user,'%')"
			+ "				), and 1=1)"
			+ "		  if(:req.appId !=null and :req.appId !='', "
			+ "         and u.app_id=:req.appId, and 1=1)"
			+ "		  if(:req.startTime !=null and :req.startTime !='', "
			+ "			and DATE_FORMAT(us.create_time,'%Y%m%d')<![CDATA[>=]]>DATE_FORMAT(:req.startTime,'%Y%m%d'), and 1=1) "
			+ "		  if(:req.endTime !=null and :req.endTime !='', "
			+ "			and DATE_FORMAT(us.create_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(:req.endTime,'%Y%m%d'), and 1=1) "
			+ "		  if(:req.remark !=null and :req.remark !='', "
			+ "			and us.remark like CONCAT('%',:req.remark,'%'), and 1=1) ", nativeQuery = true)
	Map<String, Object> userScoreListSum(@Param("req")ReqUserScoreList req);
	
}
