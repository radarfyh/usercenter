package work.metanet.server.usercenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import work.metanet.server.usercenter.domain.UcAppStore;

public interface AppStoreRepository extends JpaRepository<UcAppStore, String> {

	UcAppStore findOneByPackageName(String packageName);

}
