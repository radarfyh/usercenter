package work.metanet.client.user.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.base.page.MyPageRequest;
import work.metanet.client.user.base.BaseController;
import work.metanet.server.usercenter.domain.UcDictionaries;
import work.metanet.server.usercenter.service.DictsService;
import work.metanet.utils.HttpResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * dictionary字典控制器
 * @author Louis & Edison
 * @date 2020/1/9
 */
@Api(tags = "字典")
@RestController
@RequestMapping("dict")
public class DictsController extends BaseController {

//	@Resource
	@DubboReference
	private DictsService dictsService;
	
	@ApiOperation(value="字典新增")
	@PreAuthorize("hasAuthority('sys:dict:add')")
	@PostMapping(value="/add")
	public HttpResult add(@RequestBody UcDictionaries record) {
		return HttpResult.ok(dictsService.save(record));
	}
	
	@ApiOperation(value="字典新增")
	@PreAuthorize("hasAuthority('sys:dict:edit')")
	@PutMapping(value="/update")
	public HttpResult update(@RequestBody UcDictionaries record) {
		return HttpResult.ok(dictsService.save(record));
	}
	
	@ApiOperation(value="字典删除")
	@PreAuthorize("hasAuthority('sys:dict:delete')")
	@DeleteMapping(value="/delete")
	public HttpResult delete(@RequestBody List<UcDictionaries> records) {
		return HttpResult.ok(dictsService.delete(records));
	}

	@ApiOperation(value="字典按页查询")
	@PreAuthorize("hasAuthority('sys:dict:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody MyPageRequest pageRequest) {
		return HttpResult.ok(dictsService.findPage(pageRequest));
	}
	
	@ApiOperation(value="字典按标签查询")
	@PreAuthorize("hasAuthority('sys:dict:view')")
	@GetMapping(value="/findByLable")
	public HttpResult findByLable(@RequestParam String label) {
		return HttpResult.ok(dictsService.findByLabel(label));
	}
}
