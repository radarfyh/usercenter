package work.metanet.server.usercenter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcRoles;

/**
 * 角色Repository
 * @author Edison
 * @date 2020/1/9
 */
@Repository
public interface RolesRepository extends JpaRepository<UcRoles, String> {
	List<UcRoles> findAll();
	List<UcRoles> findByName(String name);
	Page<UcRoles> findAll(Pageable page);
	Page<UcRoles> findByName(String name, Pageable page);
	/**
	 * @param id
	 * @return
	 */
	Optional<UcRoles> findById(String id);
	/**
	 * @param id
	 */
	void deleteById(String id);
}
