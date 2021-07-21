package work.metanet.client.user.controller;

import java.util.List;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.constant.SysConstants;
import work.metanet.server.usercenter.domain.UcAcls;
import work.metanet.server.usercenter.domain.UcRoles;
import work.metanet.base.page.MyPageRequest;
import work.metanet.server.usercenter.service.RolesService;
import work.metanet.utils.HttpResult;

import io.swagger.annotations.Api;

/**
 * 角色控制器
 * @author Edison F.
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
@Api(tags = "角色")
@RestController
@RequestMapping("role")
public class RolesController {

//	@Resource
	@DubboReference
	private RolesService rolesService;
	
	@PreAuthorize("hasAuthority('sys:role:add') AND hasAuthority('sys:role:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody UcRoles record) {
		UcRoles role = rolesService.findById(record.getId());
		if(role != null) {
			if(SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
				return HttpResult.error("超级管理员不允许修改!");
			}
		}
		// 新增角色
		if((record.getId() == null || record.getId().isEmpty()) && 
				!rolesService.findByName(record.getName()).isEmpty()) {
			return HttpResult.error("角色名已存在!");
		}
		return HttpResult.ok(rolesService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:role:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<UcRoles> records) {
		return HttpResult.ok(rolesService.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:role:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody MyPageRequest pageRequest) {
		return HttpResult.ok(rolesService.findPage(pageRequest));
	}
	
	@PreAuthorize("hasAuthority('sys:role:view')")
	@GetMapping(value="/findAll")
	public HttpResult findAll() {
		return HttpResult.ok(rolesService.findAll());
	}
	
	@PreAuthorize("hasAuthority('sys:role:view')")
	@GetMapping(value="/findRoleMenus")
	public HttpResult findRoleMenus(@RequestParam String roleId) {
		return HttpResult.ok(rolesService.findRoleMenus(roleId));
	}
	
	@PreAuthorize("hasAuthority('sys:role:view')")
	@PostMapping(value="/saveRoleMenus")
	public HttpResult saveRoleMenus(@RequestBody List<UcAcls> records) {
		for(UcAcls record:records) {
			UcRoles role = rolesService.findById(record.getRoleId());
			if(role != null && SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
				// 如果是超级管理员，不允许修改
				return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
			}
		}
		return HttpResult.ok(rolesService.saveRoleMenus(records));
	}
}
