package work.metanet.client.user.controller;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.app.IAppService;
import work.metanet.api.device.IDeviceService;
import work.metanet.api.upgradePlan.protocol.ReqUpgrade;
import work.metanet.api.upgradePlan.protocol.ReqUpgrade.RespUpgrade;
import work.metanet.api.versionModule.IAppVersionModuleService;
import work.metanet.api.versionModule.protocol.ReqViewAppVersionModule.RespViewAppVersionModule;
import work.metanet.client.user.base.BaseController;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"应用"})
@RestController
@RequestMapping("api/app")
public class AppController extends BaseController {
	
	@DubboReference
	private IAppService appService;
	@DubboReference
	private IDeviceService deviceService;
	@DubboReference
	private IAppVersionModuleService appVersionModuleService;
	
	@ApiOperation(value="产品升级")
	@PostMapping("upgrade")
	public ResultResponse<RespUpgrade> upgrade(@Valid @RequestBody ReqUpgrade req) throws Exception {
		//luoxi-temp完善旧数据缺失导致认证失败问题
		if(StrUtil.isNotBlank(req.getWirelessMac()) && StrUtil.isNotBlank(req.getSerialNumber())) {
			deviceService.repairDeviceSerialNumber(req.getWirelessMac(), req.getSerialNumber());
		}
		if(StrUtil.isNotBlank(req.getDeviceId())) {
			return ResultResponseEnum.MODIFY_SUCCESS.resultResponse(appService.upgrade(req, getVersionCode(), getPackageName()));			
		}else {
			return ResultResponseEnum.MODIFY_SUCCESS.resultResponse(appService.upgrade_v2(req, getVersionCode(), getPackageName()));
		}
	}
	
	@ApiOperation(value="应用查询模块")
	@PostMapping("viewAppVersionModule")
	public ResultResponse<RespViewAppVersionModule> viewAppVersionModule() throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(appVersionModuleService.viewAppVersionModule(getPackageName(),getVersionCode()));
	}
	
}
