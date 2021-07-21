package work.metanet.server.usercenter.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcLogs;

/**
 * 日志Repository
 * @author Edison
 * @date 2020/1/9
 */
@Repository
public interface LogsRepository extends JpaRepository<UcLogs, String> {
	Page<UcLogs> findByUserName(String userName, Pageable page);

	/**
	 * @param id
	 * @return
	 */
	Optional<UcLogs> findById(String id);
}
