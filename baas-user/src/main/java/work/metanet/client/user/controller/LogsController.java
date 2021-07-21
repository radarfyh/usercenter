package work.metanet.client.user.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.server.usercenter.service.LogsService;
import work.metanet.base.page.MyPageRequest;
import work.metanet.utils.HttpResult;

import io.swagger.annotations.Api;

/**
 * log日志控制器
 * @author Louis & Edison
 * @date 2020/1/9
 */
@Api(tags = "日志")
@RestController
@RequestMapping("log")
public class LogsController {

//	@Resource
	@DubboReference
	private LogsService logsService;

	@PreAuthorize("hasAuthority('sys:log:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody MyPageRequest pageRequest) {
		return HttpResult.ok(logsService.findPage(pageRequest));
	}
}
