package work.metanet.server.usercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import work.metanet.api.fmcollect.protocol.ReqFmCollectList.RespFmCollectList;
import work.metanet.server.usercenter.domain.UcCollections;

@Repository
public interface FmCollectRepository extends JpaRepository<UcCollections, String> {
	
	/**
	 * @Description: 获取用户某资源收藏记录
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/27
	 */
	@Query(value = "SELECT * FROM uc_collections cl where cl.user_id=:userId "
			+ "and cl.content_id=:resourceId limit 1" , nativeQuery = true)
	UcCollections getFmCollect(@Param("userId")String userId, @Param("resourceId")String resourceId);
	
	/**
	 * @Description: 资源收藏列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/27
	 */
	@Query(value = "SELECT"
			+ "			cs.fm_collect_id,"
			+ "			cs.resource_id,"
			+ "			cs.content_id"
			+ "		FROM uc_collections cs"
			+ "		where 1=1"
			+ "			and cs.user_id=:userId"
			+ "		order by cs.update_time desc", nativeQuery = true)
	List<RespFmCollectList> fmCollectList(@Param("userId")String userId);
	
}
