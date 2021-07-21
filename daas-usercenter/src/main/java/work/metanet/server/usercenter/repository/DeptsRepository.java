package work.metanet.server.usercenter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcDepartments;

/**
 * 部门Repository
 * @author Edison
 * @date 2020/1/9
 */
@Repository
public interface DeptsRepository extends JpaRepository<UcDepartments, String> {
	List<UcDepartments> findAll();

	/**
	 * @param id
	 * @return
	 */
	Optional<UcDepartments> findById(String id);

	/**
	 * @param id
	 */
	void deleteById(String id);
}
