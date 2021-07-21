package work.metanet.server.usercenter.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import work.metanet.constant.SysConstants;
import work.metanet.base.page.MyPageHelper;
import work.metanet.server.usercenter.repository.AclsRepository;
import work.metanet.server.usercenter.repository.ResourcesRepository;
import work.metanet.server.usercenter.repository.RolesRepository;
import work.metanet.server.usercenter.repository.UsersRepository;
import work.metanet.server.usercenter.service.ResourcesService;
import work.metanet.server.usercenter.domain.UcAcls;
import work.metanet.server.usercenter.domain.UcResources;
import work.metanet.server.usercenter.domain.UcRoles;
import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;

/**
 * resource管理
 * @author Louis & Edison
 * @date 2020/1/9
 */
@DubboService
public class ResourcesServiceImpl implements ResourcesService {
	private static Logger log = LogManager.getLogger(ResourcesServiceImpl.class);

	@Autowired
	private ResourcesRepository resourcesRepo;
	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private RolesRepository rolesRepo;
	@Autowired
	private AclsRepository aclsRepo;

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcResources record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcResources record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcResources record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<UcResources> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcResources> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(UcResources record) {
		if(record.getParentId() == null) {
			record.setParentId("");
		}
		resourcesRepo.save(record);
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(UcResources record) {
		resourcesRepo.deleteById(record.getId());
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(List<UcResources> records) {
		for(UcResources record:records) {
			delete(record);
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public UcResources findById(String id) {
		Optional<UcResources> resource = resourcesRepo.findById(id);
		if(resource.isPresent()) {
			return resource.get();
		}
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageRequest.toJSON());

		Page<UcResources> result = null;
		Pageable page = PageRequest.of(pageRequest.getPageNum() - 1, pageRequest.getPageSize());

		result = resourcesRepo.findAll(page);
				
		// 转换格式
		MyPageResult pageResult = MyPageHelper.getPageResult(result);
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageResult.toJSON());

		return pageResult;
	}
	
	@Override
	public List<UcResources> findTree(String userName, int menuType) {
		List<UcResources> resources = new ArrayList<>();
		List<UcResources> menus = findByUser(userName);
		for (UcResources menu : menus) {
			String id = menu.getParentId();
			if (id == null || id.isEmpty() || id.equals("0")) {
				menu.setLevel(0);
				if(!exists(resources, menu)) {
					resources.add(menu);
				}
			}
		}
		if (resources.size() > 0) {
			resources.sort((o1, o2) -> o1.getSort().compareTo(o2.getSort()));
			findChildren(resources, menus, menuType);
		}
		return resources;
	}

	@Override
	public List<UcResources> findByUser(String userName) {
		//获取用户
		if(userName == null || userName.isEmpty()) {
			userName = SysConstants.ADMIN; // 如果传入空，则当做管理员处理
		}
		List<UcUsers> users = usersRepo.findByUsername(userName);
//		if(users.isEmpty()) {
//			return null;
//		}
		//获取角色
		List<UcResources> resources = new ArrayList<>();
		for(UcUsers user:users) {
			Optional<UcRoles> r = rolesRepo.findById(user.getId());
			if(r.isPresent()) {
				//超级管理员角色的默认code为admin，默认名称为“超级管理员”
				if(SysConstants.ADMIN.equalsIgnoreCase(r.get().getCode())) {
					// 如果是超级管理员，返回全部
					return resourcesRepo.findAll();
				}
				//获取权限
				List<UcAcls> acls = aclsRepo.findByRoleId(r.get().getId());
				for(UcAcls acl:acls) {
					//获取权限指向的资源
					Optional<UcResources> resource = resourcesRepo.findById(acl.getResourceId());
					if(resource.isPresent()) {
						resources.add(resource.get());
					}
				}
			}
		}
		//调试信息
		log.log(Level.forName("NOTICE", 450),resources);
		
		return resources;
	}

	private void findChildren(List<UcResources> resources, List<UcResources> menus, int menuType) {
		for (UcResources resource : resources) {
			List<UcResources> children = new ArrayList<>();
			for (UcResources menu : menus) {
				if(menuType == 1 && menu.getResourceType() == 2) {
					// 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
					continue ;
				}
				if (resource.getId() != null && resource.getId().equals(menu.getParentId())) {
					menu.setParentName(resource.getName());
					menu.setLevel(resource.getLevel() + 1);
					if(!exists(children, menu)) {
						children.add(menu);
					}
				}
			}
			resource.setChildren(children);
			children.sort((o1, o2) -> o1.getSort().compareTo(o2.getSort()));
			findChildren(children, menus, menuType);
		}
	}

	private boolean exists(List<UcResources> sysMenus, UcResources sysMenu) {
		boolean exist = false;
		for(UcResources menu:sysMenus) {
			if(menu.getId().equals(sysMenu.getId())) {
				exist = true;
			}
		}
		return exist;
	}
	
}
