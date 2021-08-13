package work.metanet.client.user.controller;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.businessApp.IBusinessAppService;
import work.metanet.api.businessApp.protocol.ReqUpgradeThirdApp;
import work.metanet.api.businessApp.vo.BusinessAppVo;
import work.metanet.client.user.base.BaseController;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"合作伙伴应用"})
@RestController
@RequestMapping("api/partnerApp")
public class PartnerAppController extends BaseController{
	
	@DubboReference
	private IBusinessAppService businessAppService;
	
	@ApiOperation(value="第三方APK升级")
	@PostMapping("upgradeThirdApp")
	public ResultResponse<BusinessAppVo> upgradeThirdApp(@Valid @RequestBody ReqUpgradeThirdApp req) throws Exception {
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse(businessAppService.upgradeThirdApp(req));
	}
	
}
