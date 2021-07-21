/**  
 * @Title: OrderMapper.java
 * @Description: TODO
 * @Author Louis & Edison & W.B.
 * @date 2018年3月28日
 */
package work.metanet.server.usercenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcUserLogins;

@Repository
public interface UserLoginRepository extends JpaRepository<UcUserLogins, String>{
	
}
