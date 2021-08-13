package work.metanet.client.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.businessSerialNumber.IBusinessSerialNumberService;
import work.metanet.api.businessSerialNumber.protocol.ReqGetBusinessSn;
import work.metanet.api.businessSerialNumber.protocol.ReqGetBusinessSn.RespGetBusinessSn;
import work.metanet.api.businessSerialNumber.protocol.ReqUpdBusinessSnUseStatus;
import work.metanet.client.user.base.BaseController;
import work.metanet.utils.ValidList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;

@Api(tags={"合作伙伴"})
@RestController
@RequestMapping("api/partner")
public class PartnerController extends BaseController{
	
	@DubboReference
	private IBusinessSerialNumberService businessSerialNumberService;
	
	@ApiOperation(value="获取激活码")
	@PostMapping("getPartnerSn")
	public ResultResponse<List<RespGetBusinessSn>> getBusinessSn(@Valid @RequestBody ValidList<ReqGetBusinessSn> req) throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(businessSerialNumberService.getBusinessSn(getPackageName(),getDeviceId(),req));
	}
	
	@ApiOperation(value="更新激活码使用状态")
	@PostMapping("updPartnerSnUseStatus")
	public ResultResponse<?> updBusinessSnUseStatus(@Valid @RequestBody ReqUpdBusinessSnUseStatus req) throws Exception {
		businessSerialNumberService.updBusinessSnUseStatus(getPackageName(),getVersionCode(),getDeviceId(),req);
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse();
	}
	
}
