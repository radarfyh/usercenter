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

import work.metanet.server.usercenter.service.ResourcesService;
import work.metanet.server.usercenter.domain.UcResources;
import work.metanet.utils.HttpResult;

import io.swagger.annotations.Api;

/**
 * 菜单控制器
 * @author Edison F.
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
@Api(tags = "资源")
@RestController
@RequestMapping("menu")
public class ResourcesController {

//	@Resource
	@DubboReference
	private ResourcesService resourcesService;
	
	@PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody UcResources record) {
		return HttpResult.ok(resourcesService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:menu:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<UcResources> records) {
		return HttpResult.ok(resourcesService.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:menu:view')")
	@GetMapping(value="/findNavTree")
	public HttpResult findNavTree(@RequestParam String userName) {
		return HttpResult.ok(resourcesService.findTree(userName, 1));
	}
	
	@PreAuthorize("hasAuthority('sys:menu:view')")
	@GetMapping(value="/findMenuTree")
	public HttpResult findMenuTree() {
		return HttpResult.ok(resourcesService.findTree(null, 0));
	}
}
