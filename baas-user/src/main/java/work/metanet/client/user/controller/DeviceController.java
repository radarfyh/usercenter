package work.metanet.client.user.controller;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.device.IDeviceService;
import work.metanet.api.device.protocol.ReqActivate;
import work.metanet.api.device.protocol.ReqActivate.RespActivate;
import work.metanet.api.device.protocol.ReqDeviceAuth;
import work.metanet.api.device.protocol.ReqDeviceAuth.RespDeviceAuth;
import work.metanet.client.user.base.BaseController;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"终端"})
@RestController
@RequestMapping("api/device")
public class DeviceController extends BaseController{
	
	@DubboReference
	private IDeviceService deviceSerivce;
	
	@ApiOperation(value="终端认证")
	@PostMapping("deviceAuth")
	public ResultResponse<RespDeviceAuth> deviceAuth(@Valid @RequestBody ReqDeviceAuth requestParam) throws Exception {
		requestParam.setPackageName(getPackageName());
		return ResultResponseEnum.AUTH_SUCCESS.resultResponse(deviceSerivce.deviceAuth(requestParam));
	}
	
	
	@ApiOperation(value="SN码激活")
	@PostMapping("activate")
	public ResultResponse<RespActivate> activate(@Valid @RequestBody ReqActivate requestParam) throws Exception {
		requestParam.setPackageName(getPackageName());
		return ResultResponseEnum.AUTH_SUCCESS.resultResponse(deviceSerivce.activate(requestParam));
	}
	
}
