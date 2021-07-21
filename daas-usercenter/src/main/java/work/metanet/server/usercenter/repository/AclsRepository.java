package work.metanet.server.usercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcAcls;

@Repository
public interface AclsRepository extends JpaRepository<UcAcls, String> {
	void deleteByRoleId(String roleId);
	List<UcAcls> findByRoleId(String roleId);
}
