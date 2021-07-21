package work.metanet.server.usercenter.service;

import java.util.List;

import work.metanet.server.usercenter.domain.UcAcls;
import work.metanet.server.usercenter.domain.UcResources;
import work.metanet.server.usercenter.domain.UcRoles;
import work.metanet.base.service.CurdService;


/**
 * role管理
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
public interface RolesService extends CurdService<UcRoles> {

	/**
	 * 查询全部
	 * @return
	 */
	List<UcRoles> findAll();

	/**
	 * 查询角色菜单集合
	 * @return
	 */
	List<UcResources> findRoleMenus(String roleId);

	/**
	 * 保存角色菜单
	 * @param records
	 * @return
	 */
	int saveRoleMenus(List<UcAcls> records);

	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	List<UcRoles> findByName(String name);
	
	/**
	 * 根据ID查询
	 * @param name
	 * @return
	 */
	UcRoles findById(String id);

}
