package work.metanet.server.usercenter.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import work.metanet.api.family.protocol.ReqFamilyMemberList.RespFamilyMemberList;
import work.metanet.api.family.protocol.ReqGrowthRecord.RespGrowthRecordVaccine;
import work.metanet.server.usercenter.domain.UcFamilyMembers;

@Repository
public interface FamilyMemberRepository extends JpaRepository<UcFamilyMembers, String> {
	
	/**
	 * @Description: 每月疫苗信息
	 */
	@Query(value = " select DATE_ADD(fm.birthday,INTERVAL v.month_age MONTH) vaccine_date, v.vaccine_info "
			+ " from uc_vaccines v "
			+ " left join (select birthday from uc_users fm where fm.status=true "
			+ " 	and fm.id = ':userId' limit 1) fm "
			+ "	on 1=1 "
			+ "	where DATE_FORMAT(DATE_ADD(fm.birthday,"
			+ " 	INTERVAL v.month_age MONTH),'%Y%m') = ':month' ", nativeQuery = true)
	List<RespGrowthRecordVaccine> vaccineList(@Param("userId")String userId, @Param("month")String month);
	
	/**
	 * @Description: 每月身标准高体重信息
	 */
	@Query(value = "select standard_type,value from ("
			+ "		  select st.standard_type, CONCAT(st.sd1_,'-',st.sd1) value,"
			+ "		    DATE_FORMAT(DATE_ADD(fm.birthday,INTERVAL st.month_age MONTH),'%Y%m') standard_date"
			+ "		    from uc_standard st"
			+ "		      join (select if(gender=0,'GIRL','BOY') sex, birthday from uc_users fm "
			+ "             where fm.status=true and fm.id = :userId limit 1) fm "
			+ "           on fm.sex=st.sex ) x"
			+ "		where :month >= standard_date"
			+ "		order by standard_date desc"
			+ "		limit 2", nativeQuery = true)
	List<Map<String, String>> getStandardHeightAndWeight(@Param("userId")String userId, 
			@Param("month")String month);
	
	/**
	 * @Description: 获取月龄
	 */
	@Query(value = "select nick_name, floor(month_age/12) age, floor(month_age%12) month "
			+ "		  from ( select nick_name, "
			+ "         PERIOD_DIFF(:month,DATE_FORMAT(fm.birthday,'%Y%m')) month_age "
			+ "		      from uc_users fm where fm.status=true "
			+ "		        and fm.id = :userId "
			+ "		limit 1 "
			+ "		) x ", nativeQuery = true)
	Map<String, Object> getMonthAge(@Param("userId")String userId, @Param("month")String month);
	
	/**
	 * @Description: 家庭成员列表
	 */
	@Query(value = "select * from uc_family_members fm "
			+ "		left join uc_users su on su.id = fm.user_id "
			+ "		left join uc_users mu on mu.id = fm.master_id "
			+ "		where fm.status=true "
			+ "		  and fm.master_id = :joinUserId", nativeQuery = true)
	List<RespFamilyMemberList> familyMemberList(@Param("joinUserId")String joinUserId);
	
	/**
	 * @Description: 家庭关系名称是否已存在
	 */
	@Query(value = "select count(1) from uc_family_members fm where fm.status=true "
			+ "		 and fm.user_id = :joinUserId and fm.relation_name = :relationName", nativeQuery = true)
	boolean existRelationName(@Param("joinUserId")String joinUserId, @Param("relationName")String relationName);
	
	
	/**
	 * @Description: 删除家庭成员
	 */
	@Modifying
	@Query(value="update uc_family_members set status=false,update_user=#{userId} "
			+ "where user_id=#{userId} and id=#{familyMemberId}", nativeQuery = true)
	int removeFamilyMember(@Param("familyMemberId")String familyMemberId, @Param("userId")String userId);
	
	/**
	 * @param familyMemberId
	 * @return
	 */
	Optional<UcFamilyMembers> findById(String id);
	
}
