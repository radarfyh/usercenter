package work.metanet.server.usercenter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcDictionaries;

/**
 * 数据字典Repository
 * @author Edison
 * @date 2020/1/9
 */
@Repository
public interface DictsRepository extends JpaRepository<UcDictionaries, String> {
	List<UcDictionaries> findByLabel(String Label);
	Page<UcDictionaries> findByLabel(String Label, Pageable page);
	/**
	 * @param id
	 */
	void deleteById(String id);
	/**
	 * @param id
	 * @return
	 */
	Optional<UcDictionaries> findById(String id);
}
