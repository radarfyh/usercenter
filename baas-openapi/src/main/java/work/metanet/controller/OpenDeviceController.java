package work.metanet.controller;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.openDevice.IOpenDeviceService;
import work.metanet.api.openDevice.protocol.ReqOpenDeviceAuth;
import work.metanet.api.openDevice.protocol.ReqOpenDeviceAuth.RespOpenDeviceAuth;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"设备"})
@RestController
@RequestMapping("api/device")
public class OpenDeviceController extends BaseController{
	
	@DubboReference
	private IOpenDeviceService openDeviceService;
	
	@ApiOperation(value="认证")
	@PostMapping("auth")
	public ResultResponse<RespOpenDeviceAuth> auth(@Valid @RequestBody ReqOpenDeviceAuth req) throws Exception {
		return ResultResponseEnum.AUTH_SUCCESS.resultResponse(openDeviceService.auth(req));
	}
	
}
