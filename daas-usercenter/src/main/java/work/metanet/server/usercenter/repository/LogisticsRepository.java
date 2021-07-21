/**
 * @Description 文件：LogisticsRepository.java
 * @author EdisonFeng
 * @DateTime 2021年6月10日
 * Copyright(c) 2021. All Rights Reserved
 */
package work.metanet.server.usercenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.metanet.server.usercenter.domain.UcUserLogistics;

@Repository
public interface LogisticsRepository extends JpaRepository<UcUserLogistics, String> {

}
