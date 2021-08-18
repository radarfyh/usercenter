package work.metanet.client.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.user.protocol.ReqAccountCancel;
import work.metanet.api.user.protocol.ReqCheckCode;
import work.metanet.api.user.protocol.ReqLogin;
import work.metanet.api.user.protocol.ReqLoginSuper;
import work.metanet.api.user.protocol.ReqRegister;
import work.metanet.api.user.protocol.ReqResetPassword;
import work.metanet.api.user.protocol.ReqSendCode;
import work.metanet.api.user.protocol.ReqUpdPassword;
import work.metanet.api.user.protocol.ReqUpdUser;
import work.metanet.api.user.protocol.ReqLogin.RespLogin;
import work.metanet.api.user.protocol.ReqUserInfo.RespUserInfo;

import cn.hutool.core.util.StrUtil;
import work.metanet.constant.SysConstants;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.base.page.MyPageRequest;
import work.metanet.client.user.base.BaseController;
import work.metanet.server.usercenter.service.UsersService;
import work.metanet.utils.PasswordUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
public class UsersController extends BaseController {
	@DubboReference
	private UsersService usersService;
	
	@ApiOperation(value="用户保存")
	@PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
	@PostMapping(value="/save")
	public ResultResponse<?> save(@RequestBody UcUsers record) {
		UcUsers user = usersService.findById(record.getId());
				
		if(user != null) {
			if(SysConstants.ADMIN.equalsIgnoreCase(user.getUsername())) {
				return ResultResponseEnum.INVALID_REQUEST.resultResponse().setMessage("超级管理员不允许修改!");
			}
		}
		if(record.getPassword() != null) {
			String salt = PasswordUtils.getSalt();
			if(user == null) {
				// 新增用户
				if(usersService.findByName(record.getUsername()) != null) {
					return ResultResponseEnum.INVALID_REQUEST.resultResponse().setMessage("用户名已存在!");
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
		return ResultResponseEnum.CREATE_SUCCESS.resultResponse(usersService.save(record));
	}

	@ApiOperation(value="用户删除")
	@PreAuthorize("hasAuthority('sys:user:delete')")
	@DeleteMapping(value="/delete")
	public ResultResponse<?> delete(@RequestBody List<UcUsers> records) {
		for(UcUsers record:records) {
			UcUsers user = usersService.findById(record.getId());
			if(user != null && SysConstants.ADMIN.equalsIgnoreCase(user.getUsername())) {
				return ResultResponseEnum.INVALID_REQUEST.resultResponse().setMessage("超级管理员不允许删除!");
			}
		}
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse(usersService.delete(records));
	}
	
	@ApiOperation(value="用户按名称查询")
	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findByName")
	public ResultResponse<?> findByUserName(@RequestParam String name) {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(usersService.findByName(name));
	}
	
	@ApiOperation(value="权限查询")
	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findPermissions")
	public ResultResponse<?> findPermissions(@RequestParam String name) {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(usersService.findPermissions(name));
	}
	
	@ApiOperation(value="用户角色查询")
	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findUserRoles")
	public ResultResponse<?> findUserRoles(@RequestParam String userId) {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(usersService.findUserRoles(userId));
	}

	@ApiOperation(value="用户按页查询")
	@PreAuthorize("hasAuthority('sys:user:view')")
	@PostMapping(value="/findPage")
	public ResultResponse<?> findPage(@RequestBody MyPageRequest pageRequest) {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(usersService.findPage(pageRequest));
	}
	
	@ApiOperation(value="发送验证码")
	@PostMapping("sendCode")
	public ResultResponse<?> sendCode(@Valid @RequestBody ReqSendCode requestParam) throws Exception {
		usersService.sendCode(getPackageName(),requestParam);
		return ResultResponseEnum.CREATE_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="校验验证码")
	@PostMapping("checkCode")
	public ResultResponse<?> checkCode(@Valid @RequestBody ReqCheckCode requestParam) throws Exception {
		usersService.checkCode(getUserId(),requestParam);
		return ResultResponseEnum.AUTH_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="注册")
	@PostMapping("register")
	public ResultResponse<?> register(@Valid @RequestBody ReqRegister requestParam) throws Exception {
		usersService.register(requestParam);
		return ResultResponseEnum.CREATE_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="登录与注册")
	@PostMapping("registerAndLogin")
	public ResultResponse<RespLogin> loginSuper(HttpServletRequest request,@Valid @RequestBody ReqLoginSuper requestParam) throws Exception {
		//获取deviceId兼容最初的版本
		String deviceId = requestParam.getDeviceId();
		RespLogin resp = usersService.loginSuper(StrUtil.isNotBlank(deviceId)?deviceId:getDeviceId(),getPackageName(),getVersionCode(),requestParam);
		return ResultResponseEnum.AUTH_SUCCESS.resultResponse(resp);
	}
	
	@ApiOperation(value="修改用户信息")
	@PostMapping("updUser")
	public ResultResponse<?> updUser(@Valid @RequestBody ReqUpdUser requestParam) throws Exception {
		usersService.updUser(getUserId(),requestParam);
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="获取用户信息")
	@PostMapping("userInfo")
	public ResultResponse<RespUserInfo> userInfo() throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(usersService.userInfo(getUserId()));
	}
	
	@ApiOperation(value="修改密码")
	@PostMapping("updPassword")
	public ResultResponse<?> updPassword(@Valid @RequestBody ReqUpdPassword requestParam) throws Exception {
		usersService.updPassword(getUserId(),requestParam);
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="重置密码")
	@PostMapping("resetPassword")
	public ResultResponse<?> resetPassword(@Valid @RequestBody ReqResetPassword requestParam) throws Exception {
		usersService.resetPassword(getUserId(),requestParam);
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="退出登录")
	@PostMapping("logout")
	public ResultResponse<?> logout() throws Exception {
		usersService.logout(getUserId());
		return ResultResponseEnum.AUTH_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="销户")
	@PostMapping("accountCancel")
	public ResultResponse<?> accountCancel(@Valid @RequestBody ReqAccountCancel req) throws Exception {
		usersService.accountCancel(getUserId(), req);
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse();
	}
}
