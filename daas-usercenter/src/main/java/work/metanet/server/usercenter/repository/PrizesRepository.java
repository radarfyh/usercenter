package work.metanet.server.usercenter.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import work.metanet.server.usercenter.domain.UcPrizes;

public interface PrizesRepository extends JpaRepository<UcPrizes, String> {
	
	@Query(value = "select"
			+ "			p.id,"
			+ "			p.prize_name,"
			+ "			p.prize_img,"
			+ "			p.score"
			+ "		from uc_prizes p"
			+ "		join uc_apps ap on ap.channel_id=p.channel_id"
			+ "		where p.`status`=true"
			+ "			and ap.`status`=true"
			+ "			and p.prize_status='UP'"
			+ "			and p.inventory>0"
			+ "			and ap.package_name=:packageName"
			+ "		ORDER BY p.update_time desc", nativeQuery = true)
	List<UcPrizes> findAllByPackageName(String packageName);
	
	@Query(value = " select * from uc_prizes where id=:prizeId for update", nativeQuery = true)
	UcPrizes getPrizeByIdLock(String prizeId);
	
	@Modifying
	@Query(value = "update uc_prizes set inventory=inventory+:number where id=:prizeId", nativeQuery = true)
	int updateInventory(@Param("prizeId")String prizeId,@Param("number")Integer number);
}
