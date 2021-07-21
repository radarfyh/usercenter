package work.metanet.server.usercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcUserRole;

/**
 * 用户角色Repository
 * @author Edison
 * @date 2020/1/9
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UcUserRole, String> {
	List<UcUserRole> findByUserId(String userId);
	void deleteByUserId(String userId);
}
