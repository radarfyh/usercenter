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
import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.base.page.MyPageRequest;
import work.metanet.server.usercenter.service.UsersService;
import work.metanet.utils.PasswordUtils;

import io.swagger.annotations.Api;

import work.metanet.utils.HttpResult;



/**
 * 用户控制器
 * @author Edison F.
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
@Api(tags = "用户")
@RestController
@RequestMapping("user")
public class UsersController {

//	@Resource
	@DubboReference
	private UsersService usersService;
	
	@PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody UcUsers record) {
		UcUsers user = usersService.findById(record.getId());
				
		if(user != null) {
			if(SysConstants.ADMIN.equalsIgnoreCase(user.getUsername())) {
				return HttpResult.error("超级管理员不允许修改!");
			}
		}
		if(record.getPassword() != null) {
			String salt = PasswordUtils.getSalt();
			if(user == null) {
				// 新增用户
				if(usersService.findByName(record.getUsername()) != null) {
					return HttpResult.error("用户名已存在!");
				}
				String password = PasswordUtils.encode(record.getPassword(), salt);
				record.setSalt(salt);
				record.setPassword(password);
			} else {
				// 修改用户, 且修改了密码
				if(!record.getPassword().equals(user.getPassword())) {
					String password = PasswordUtils.encode(record.getPassword(), salt);
					record.setSalt(salt);
					record.setPassword(password);
				}
			}
		}
		return HttpResult.ok(usersService.save(record));

	}

	@PreAuthorize("hasAuthority('sys:user:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<UcUsers> records) {
		for(UcUsers record:records) {
			UcUsers user = usersService.findById(record.getId());
			if(user != null && SysConstants.ADMIN.equalsIgnoreCase(user.getUsername())) {
				return HttpResult.error("超级管理员不允许删除!");
			}
		}
		return HttpResult.ok(usersService.delete(records));

	}
	
	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findByName")
	public HttpResult findByUserName(@RequestParam String name) {
		return HttpResult.ok(usersService.findByName(name));

	}
	
	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findPermissions")
	public HttpResult findPermissions(@RequestParam String name) {
		return HttpResult.ok(usersService.findPermissions(name));

	}
	
	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findUserRoles")
	public HttpResult findUserRoles(@RequestParam String userId) {
		return HttpResult.ok(usersService.findUserRoles(userId));

			
	}

	@PreAuthorize("hasAuthority('sys:user:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody MyPageRequest pageRequest) {
		return HttpResult.ok(usersService.findPage(pageRequest));

	}
}
