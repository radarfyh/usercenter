package work.metanet.server.usercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import work.metanet.api.fmbrowse.protocol.ReqFmBrowseList.RespFmBrowseList;
import work.metanet.server.usercenter.domain.UcBrowses;

@Repository
public interface FmBrowseRepository extends JpaRepository<UcBrowses, String> {
	
	/**
	 * @Description: 获取用户某资源浏览记录
	 */
	@Query(value = "select * from uc_browses where user_id=:userId and content_id=:resourceId"
			, nativeQuery = true)
	UcBrowses getFmBrowse(@Param("userId")String userId, @Param("resourceId")String resourceId);
	
	@Modifying
	@Query(value = "update uc_browses set update_time=now() where id=:fmBrowseId"
			, nativeQuery = true)
	int updateFmBrowseTime(@Param("fmBrowseId")String fmBrowseId);
	
	/**
	 * @Description: 资源浏览记录列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/27
	 */
	@Query(value = "SELECT"
			+ "			bs.id,"
			+ "			bs.resource_id,"
			+ "			bs.content_id"
			+ "		FROM uc_browses bs"
			+ "		where bs.user_id=:userId"
			+ "		order by bs.update_time desc", nativeQuery = true)
	List<RespFmBrowseList> fmBrowseList(@Param("userId")String userId);
	
	/**
	 * @Description: 溢出删除
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/20
	 */
	@Query(value = "delete a from uc_browses a"
			+ "		  join ("
			+ "		    select * from (select (@row_number:=@row_number+1) row_number,id "
			+ "           from uc_browses fm,(select @row_number := 0) tmp_row_number "
			+ "             where user_id=:userId order by update_time desc) a "
			+ "         where row_number>100 "
			+ "		  )b on b.id=a.id", nativeQuery = true)
	int fmBrowseOverflow(@Param("userId")String userId);
	
}
