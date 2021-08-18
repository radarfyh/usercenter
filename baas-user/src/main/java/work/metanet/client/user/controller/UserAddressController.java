package work.metanet.client.user.controller;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.userAddress.protocol.ReqSaveUserAddress;
import work.metanet.client.user.base.BaseController;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.server.usercenter.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"物流地址"})
@RestController
@RequestMapping("api/userAddress")
public class UserAddressController extends BaseController{
	
	@DubboReference
	private AddressService userAddressService;
	
	@ApiOperation(value="收货地址信息")
	@PostMapping("userAddressInfo")
	public ResultResponse<?> userAddressInfo() throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(userAddressService.userAddressInfo(getUserId()));
	}
	
	@ApiOperation(value="保存收货地址")
	@PostMapping("saveUserAddress")
	public ResultResponse<?> saveUserAddress(@Valid @RequestBody ReqSaveUserAddress req) throws Exception {
		userAddressService.saveUserAddress(getUserId(), req);
		return ResultResponseEnum.CREATE_SUCCESS.resultResponse();
	}
	
}
