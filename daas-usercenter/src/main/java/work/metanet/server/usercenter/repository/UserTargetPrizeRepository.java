package work.metanet.server.usercenter.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import work.metanet.api.userTargetPrize.protocol.ReqUserTargetPrizeInfo.RespUserTargetPrizeInfo;
import work.metanet.server.usercenter.domain.UcTargetPrizes;

public interface UserTargetPrizeRepository extends JpaRepository<UcTargetPrizes, String> {
	@Query(value = "select"
			+ "			p.id,"
			+ "			p.prize_name,"
			+ "			p.prize_img,"
			+ "			p.score"
			+ "		from uc_target_prizes utp"
			+ "		join uc_prizes p "
			+ "			on p.id=utp.prize_id"
			+ "		where 1=1"
			+ "			and utp.user_id=:userId"
			+ "			limit 1", nativeQuery = true)
	RespUserTargetPrizeInfo userTargetPrizesInfo(@Param("userId")String userId);
	
	@Query(value = "select * from uc_target_prizes "
			+ "where user_id=:userId limit 1", nativeQuery = true)
	UcTargetPrizes userTargetPrize(String userId);
	
	@Query(value = "select"
			+ "			CAST(us.`value`/p.score*100 as DECIMAL(9,2))"
			+ "		from uc_user_scores us"
			+ "		left join uc_target_prizes utp "
			+ "			on utp.user_id=us.user_id"
			+ "		left join uc_prizes p "
			+ "			on p.id=utp.prize_id"
			+ "		where us.user_id=:userId", nativeQuery = true)
	BigDecimal prizeCompletion(@Param("userId")String userId);

	/**
	 * @param id
	 * @return
	 */
	Optional<UcTargetPrizes> findById(String id);
}
