package work.metanet.server.usercenter.service;

import java.util.List;

import work.metanet.server.usercenter.domain.UcDepartments;
import work.metanet.base.service.CurdService;

/**
 * department/organization管理
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
public interface DeptsService extends CurdService<UcDepartments> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<UcDepartments> findTree();
}
