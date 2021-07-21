package work.metanet.server.usercenter.service;

import java.util.List;

import work.metanet.server.usercenter.domain.UcResources;
import work.metanet.base.service.CurdService;

/**
 * resource管理
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
public interface ResourcesService extends CurdService<UcResources> {

	/**
	 * 查询菜单树,用户ID和用户名为空则查询全部
	 * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
	 * @param userId 
	 * @return
	 */
	List<UcResources> findTree(String userName, int menuType);

	/**
	 * 根据用户名查找菜单列表
	 * @param userName
	 * @return
	 */
	List<UcResources> findByUser(String userName);
}
