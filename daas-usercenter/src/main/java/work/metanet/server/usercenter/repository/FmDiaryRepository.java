package work.metanet.server.usercenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcDiaries;

@Repository
public interface FmDiaryRepository extends JpaRepository<UcDiaries, String> {
	
}
