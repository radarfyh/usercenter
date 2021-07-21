package work.metanet.server.usercenter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcResources;

/**
 * 资源Repository
 * @author Edison
 * @date 2020/1/9
 */
@Repository
public interface ResourcesRepository extends JpaRepository<UcResources, String> {
	List<UcResources> findByName(String name);
	
	List<UcResources> findAll();
	//List<Resources> findByUserName(String userName);

	/**
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * @param id
	 * @return
	 */
	Optional<UcResources> findById(String id);
}
