package work.metanet.server.usercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcUserDept;

/**
 * 用户部门Repository
 * @author Edison
 * @date 2020/1/9
 */
@Repository
public interface UserDeptRepository extends JpaRepository<UcUserDept, String> {
	List<UcUserDept> findByUserId(String userId);
	void deleteByUserId(String userId);
}
