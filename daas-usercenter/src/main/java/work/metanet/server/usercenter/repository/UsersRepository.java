package work.metanet.server.usercenter.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.server.usercenter.domain.UserFromThird;
import work.metanet.api.user.protocol.ReqRemoveUser;
import work.metanet.api.user.protocol.ReqUserInfo;
import work.metanet.api.user.protocol.ReqUserList.RespUserList;

/**
 * 用户Repository
 * @author Edison
 * @date 2020/1/9
 */
@Repository
public interface UsersRepository extends JpaRepository<UcUsers, String> {
	Page<UcUsers> findAll(Pageable pageable);
	List<UcUsers> findByUsername(String username);
	Page<UcUsers> findByUsername(String username, Pageable pageable);
	
//	@Query(value = "select u.*, a.email "
//				+ "		from uc_users left join uc_user_addresses a on id = a.user_id  "
//				+ "		where username = ?1 and a.email = ?2 "
//				+ "			and status=true ORDER BY ?#{#pageable} ", 
//			countQuery = "select count(1) "
//				+ "		from uc_users left join uc_user_addresses a on id = a.user_id  "
//				+ "		where username = ?1 and a.email = ?2 "
//				+ "			and status=true",
//			nativeQuery = true)
	Page<UcUsers> findByUsernameAndEmail(String username, String email, Pageable pageable);

	Optional<UcUsers> findById(String id);
	
	Optional<UcUsers> findFirstByAppIdAndPhone(String appId, String phone);
	
	@Query(value = "select"
			+ "		count(1)"
			+ "		from uc_users u"
			+ "		where u.status=true and u.appid=?1", nativeQuery = true)
	Integer userTotal(String appId);
	

	@Query(value = "select DATE_FORMAT(birthday,'%Y-%m-%d') birthday,u.* from uc_users u where u.status=1"
			+ "		left join uc_user_addresses ua on u.id=ua.user_id"
			+ "		  IF(?1 !=null and ?1 !='', "
			+ "         and u.app_id=?1, and 1=1)"
			+ "		  IF(?2 !=null and ?2 !='', "
			+ "         and u.username=?2, and 1=1)"
			+ "		  IF(?3 !=null and ?3 !='', "
			+ "         and u.phone=?3, and 1=1)"
			+ "		  IF(?4 !=null and ?4 !='', "
			+ "         and ua.email=?4, and 1=1)"
			+ "		  IF(?5 !=null and ?5 !='', "
			+ "         and u.enable_status=?5, and 1=1)", nativeQuery = true)
	UcUsers getUser(String appID, String username, String phone, String email, String enableStatus);
	
	@Query(value = "select "
			+ "			u.user_id,"
			+ "			u.phone,"
			+ "			DATE_FORMAT(u.create_time,'%Y-%m-%d %H:%i:%s') create_time,"
			+ "			lg.device_id,"
			+ "		from uc_users u "
			+ "			left join("
			+ "			select lg.*"
			+ "			from uc_user_logins lg"
			+ "			left join uc_user_logins lg2 on lg2.user_id=lg.user_id and lg2.create_time>lg.create_time"
			+ "			WHERE ISNULL(lg2.id)"
			+ "			) lg on lg.user_id=u.user_id"
			+ "		where 1=1"
			+ "			AND u.status=true"
			+ "		  IF(?2 !=null and ?2 !='', "
			+ "			and ("
			+ "				u.user_id like CONCAT('%',?2,'%') or"
			+ "				u.phone like CONCAT('%',?2,'%') or"
			+ "				u.email like CONCAT('%',?2,'%')"
			+ "				), and 1=1)"
			+ "		  IF(?3 !=null and ?3 !='', "
			+ "         and u.app_id=?3, and 1=1)"
			+ "		  IF(?5 !=null and ?5 !='', "
			+ "			and DATE_FORMAT(u.create_time,'%Y%m%d')<![CDATA[>=]]>DATE_FORMAT(?5,'%Y%m%d'), and 1=1)"
			+ "		  IF(?6 !=null and ?6 !='', "
			+ "			and DATE_FORMAT(u.create_time,'%Y%m%d')<![CDATA[<=]]>DATE_FORMAT(?6,'%Y%m%d'), and 1=1)"
			+ "		  IF(?7 !=null, "
			+ "         and u.enable_status=?7, and 1=1)"
			+ "		  IF(?8 !=null and ?8 !='', "
			+ "			and u.remark like CONCAT('%',?8,'%'), and 1=1)"
			+ "		ORDER BY u.create_time desc", nativeQuery = true)
	List<RespUserList> getUserList(String channelId, String user, String appId, String device, 
			String startTime, String endTime, Boolean enableStatus, String remark);
	
	@Modifying
	@Query(value = "update uc_users set status=false "
			+ "		where user_id in(:list)", nativeQuery = true)
	int removeUser(@Param("list")List<ReqRemoveUser> list);

	@Query(value = "select * from uc_users"
			+ "		where phone = :uft.ownerTel"
			+ "		order by create_time desc limit 1", nativeQuery = true)
	ReqUserInfo.RespUserInfo userInfoFromThird(@Param("uft")UserFromThird uft);

	@Modifying
	@Query(value = "update uc_users"
			+ "        set"
			+ "            IF(?1 !=null and ?1 !='', username = ?1, 1=1)"
			+ "            IF(?2 !=null and ?2 !='', nick_name = ?2, 1=1)"
			+ "            IF(?3 !=null, age = ?3, 1=1)"
			+ "            IF(?4 !=null and ?4 !='', phone = ?4, 1=1)"
			+ "        where"
			+ "            user_id = ?5", nativeQuery = true)
	void updateUserById(String ownerId, String ownerName, Integer ownerAge, String ownerTel, String userId);

	/**
	 * @param id
	 * @return
	 */
	UcUsers findFirstById(String id);
}
