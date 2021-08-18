package work.metanet.server.usercenter.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import work.metanet.server.usercenter.domain.UcPrizes;

public interface PrizesRepository extends JpaRepository<UcPrizes, String> {
	List<UcPrizes> findAllByPackageName(String packageName);
	
	@Query(value = " select * from t_prize where prize_id=:prizeId for update", nativeQuery = true)
	UcPrizes getPrizeByIdLock(String prizeId);
	
	@Modifying
	@Query(value = "update t_prize set inventory=inventory+:number where prize_id=:prizeId", nativeQuery = true)
	int updateInventory(@Param("prizeId")String prizeId,@Param("number")Integer number);
}
