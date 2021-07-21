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
import org.springframework.transaction.annotation.Transactional;

import work.metanet.constant.SysConstants;
import work.metanet.base.page.MyPageHelper;
import work.metanet.server.usercenter.repository.AclsRepository;
import work.metanet.server.usercenter.repository.ResourcesRepository;
import work.metanet.server.usercenter.repository.RolesRepository;
import work.metanet.server.usercenter.service.RolesService;
import work.metanet.server.usercenter.domain.UcAcls;
import work.metanet.server.usercenter.domain.UcResources;
import work.metanet.server.usercenter.domain.UcRoles;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;

/**
 * role管理
 * @author Louis & Edison
 * @date 2020/1/9
 */
@DubboService
public class RolesServiceImpl  implements RolesService {
	private static Logger log = LogManager.getLogger(RolesServiceImpl.class);

	@Autowired
	private RolesRepository rolesRepo;
	@Autowired
	private AclsRepository aclsRepo;
	@Autowired
	private ResourcesRepository resourcesRepo;
	
	@Override
	public int save(UcRoles record) {

		rolesRepo.save(record);
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(UcRoles record) {
		rolesRepo.deleteById(record.getId());
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(List<UcRoles> records) {
		for(UcRoles record:records) {
			delete(record);
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public UcRoles findById(String id) {
		Optional<UcRoles> role = rolesRepo.findById(id);
		if(role.isPresent()) {
			return role.get();
		}
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageRequest.toJSON());

		Page<UcRoles> result = null;
		String name = MyPageHelper.getColumnFilterValue(pageRequest, "name");
		
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		Pageable page = PageRequest.of(pageRequest.getPageNum() - 1, pageRequest.getPageSize(), sort);
		if(name != null && !name.isEmpty()) {
			result = rolesRepo.findByName(name, page);
		} else {
			result = rolesRepo.findAll(page);
		}
				
		// 转换格式
		MyPageResult pageResult = MyPageHelper.getPageResult(result);
		
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageResult.toJSON());
				
		return pageResult;
	}

	@Override
	public List<UcRoles> findAll() {
		return rolesRepo.findAll();
	}
	
	public Iterable<UcRoles> findIterable() {
		return rolesRepo.findAll();
	}

	public RolesRepository getUcRolesRepo() {
		return rolesRepo;
	}

	public void setUcRolesRepo(RolesRepository rolesRepo) {
		this.rolesRepo = rolesRepo;
	}

	@Override
	public List<UcResources> findRoleMenus(String roleId) {
		Optional<UcRoles> role = rolesRepo.findById(roleId);
		if(role.isPresent() && SysConstants.ADMIN.equalsIgnoreCase(role.get().getName())) {
			// 如果是超级管理员，返回全部
			return resourcesRepo.findAll();
		}
		List<UcResources> resources = new ArrayList<>();
		List<UcAcls> acls = aclsRepo.findByRoleId(roleId);
		for(UcAcls acl:acls) {
			Optional<UcResources> resource = resourcesRepo.findById(acl.getResourceId());
			if(resource.isPresent()) {
				resources.add(resource.get());
			}
		}
		//调试信息
		log.log(Level.forName("NOTICE", 450),resources);
		
		return resources;
	}

	@Transactional
	@Override
	public int saveRoleMenus(List<UcAcls> records) {
		if(records == null || records.isEmpty()) {
			return 1;
		}
		String roleId = records.get(0).getRoleId(); 
		aclsRepo.deleteByRoleId(roleId);
		for(UcAcls record:records) {
			aclsRepo.save(record);
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public List<UcRoles> findByName(String name) {
		return rolesRepo.findByName(name);
	}

	@Override
	public int add(UcRoles record) {
		
		return save(record);
	}

	@Override
	public int update(String id, UcRoles record) {
		return save(record);
	}

	@Override
	public int update(UcRoles record) {
		
		return save(record);
	}

	@Override
	public int delete(String id) {
		UcRoles role = new UcRoles();
		role.setId(id);
		return delete(role);
	}

	@Override
	public Iterable<UcRoles> findAllSort(Sort sort) {
		
		return findAll();
	}

	@Override
	public Page<UcRoles> findAll(Pageable page) {
		
		return null;
	}

}
