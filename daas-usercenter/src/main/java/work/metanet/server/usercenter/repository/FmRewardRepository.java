package work.metanet.server.usercenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcRewards;

@Repository
public interface FmRewardRepository extends JpaRepository<UcRewards, String> {
	
	@Query(value="select if(count(1)=0,0,1) from uc_rewards "
			+ "where user_id=:req.userId and content_id=:req.resourceId", nativeQuery = true)
	boolean existsReward(@Param("req")UcRewards req);
	
}
