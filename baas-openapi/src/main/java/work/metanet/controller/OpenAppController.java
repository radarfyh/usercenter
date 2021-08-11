package work.metanet.controller;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.openAppBusiness.IOpenAppBusinessService;
import work.metanet.api.openAppBusiness.protocol.ReqOpenAppBusinessKey;
import work.metanet.api.openAppBusiness.protocol.ReqOpenAppBusinessKey.RespOpenAppBusinessKey;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"应用"})
@RestController
@RequestMapping("api/app")
public class OpenAppController extends BaseController{
	
	@DubboReference
	private IOpenAppBusinessService openAppThirdService;
	
	@ApiOperation(value="获取业务KEY")
	@PostMapping("getBusinessKey")
	public ResultResponse<RespOpenAppBusinessKey> getOpenAppBusinessKey(@Valid @RequestBody ReqOpenAppBusinessKey req) throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(openAppThirdService.getOpenAppBusinessKey(getAppId(),req.getBusinessCode()));
	}
	
}
