package work.metanet.client.user.controller;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.storeApp.IStoreAppService;
import work.metanet.api.storeApp.protocol.ReqSearchStoreApp;
import work.metanet.api.storeApp.protocol.ReqSearchStoreApp.RespSearchStoreApp;
import work.metanet.client.user.base.BaseController;
import work.metanet.base.RespPaging;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;

@Api(tags={"应用商店"})
@RestController
@RequestMapping("api/storeApp")
public class StoreAppController extends BaseController{
	
	@DubboReference
	private IStoreAppService storeAppService;
	
	@ApiOperation(value="搜索应用")
	@PostMapping("searchStoreApp")
	public ResultResponse<RespPaging<RespSearchStoreApp>> searchStoreApp(@Valid @RequestBody ReqSearchStoreApp req) throws Exception {
		req.setPackageName(getPackageName());
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(storeAppService.searchStoreApp(req));
	}
	
}
