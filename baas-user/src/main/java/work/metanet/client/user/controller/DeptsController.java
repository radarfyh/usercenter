package work.metanet.client.user.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.server.usercenter.domain.UcDepartments;
import work.metanet.server.usercenter.service.DeptsService;
import work.metanet.utils.HttpResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * department部门/机构控制器
 * @author Edison F.
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
@Api(tags = "部门")
@RestController
@RequestMapping("departments")
public class DeptsController {

//	@Resource
	@DubboReference
	private DeptsService deptsService;
	
	@ApiOperation(value="部门新增")
	@PreAuthorize("hasAuthority('sys:dept:add')")
	@PostMapping(value="/")
	public HttpResult add(@RequestBody UcDepartments record) {
		return HttpResult.ok(deptsService.add(record));
	}
	
	@ApiOperation(value="部门修改")
	@PreAuthorize("hasAuthority('sys:dept:edit')")
	@PutMapping(value="/{id}")
	public HttpResult update(@PathVariable String id, @RequestBody UcDepartments record) {
		return HttpResult.ok(deptsService.update(id, record));
	}

	@ApiOperation(value="部门删除1")
	@PreAuthorize("hasAuthority('sys:dept:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<UcDepartments> records) {
		return HttpResult.ok(deptsService.delete(records));
	}
	
	@ApiOperation(value="部门删除2")
	@PreAuthorize("hasAuthority('sys:dept:delete')")
	@DeleteMapping(value="/{id}")
	public HttpResult delete(@PathVariable String id) {
		return HttpResult.ok(deptsService.delete(id));
	}
	
	@ApiOperation(value="部门查询1")
	@PreAuthorize("hasAuthority('sys:dept:view')")
	@GetMapping(value="/{id}")
	public HttpResult findById(@PathVariable String id) {
		return HttpResult.ok(deptsService.findById(id));
	}

	@ApiOperation(value="部门查询2")
	@PreAuthorize("hasAuthority('sys:dept:view')")
	@GetMapping(value="/findTree")
	public HttpResult findTree() {
		return HttpResult.ok(deptsService.findTree());
	}
	
	@ApiOperation(value="部门查询3")
	@PreAuthorize("hasAuthority('sys:dept:view')")
	@GetMapping(value="/{length}/{start}")
	public HttpResult findPage(@PathVariable("length") int length, @PathVariable("start") int start) {
		
		MyPageRequest pageRequest = new MyPageRequest();
		pageRequest.setPageSize(length);
		pageRequest.setPageNum(start/length);
		
		MyPageResult pageResult = deptsService.findPage(pageRequest);
		
		return HttpResult.ok(pageResult);
	}

}
