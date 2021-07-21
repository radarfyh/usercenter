package work.metanet.server.usercenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcUserAddresses;

@Repository
public interface UserAddressRepository extends JpaRepository<UcUserAddresses, String> {
	
	@Query(value = "select * from uc_user_addresses where user_id=?1 and default_status=true"
			, nativeQuery = true)
	UcUserAddresses userAddressInfo(String userId);
	
}
