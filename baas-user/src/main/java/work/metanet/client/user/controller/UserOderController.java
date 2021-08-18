package work.metanet.client.user.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.userTargetPrize.protocol.ReqSaveUserTargetPrize;
import work.metanet.api.userTargetPrize.protocol.ReqUserTargetPrizeInfo.RespUserTargetPrizeInfo;
import work.metanet.client.user.base.BaseController;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.server.usercenter.service.TargetPrizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"用户订购"})
@RestController
@RequestMapping("api/userOrder")
public class UserOderController extends BaseController{
	
	@DubboReference
	private TargetPrizeService userTargetPrizeService;
	
	@ApiOperation(value="用户订购信息")
	@PostMapping("userOrderInfo")
	public ResultResponse<RespUserTargetPrizeInfo> userTargetPrizeInfo() throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(userTargetPrizeService.userTargetPrizeInfo(getUserId()));
	}
	
	@ApiOperation(value="保存用户订购")
	@PostMapping("saveOrderProze")
	public ResultResponse<?> saveUserTargetProze(@Valid @RequestBody ReqSaveUserTargetPrize req) throws Exception {
		userTargetPrizeService.saveUserTargetProze(getUserId(), req);
		return ResultResponseEnum.CREATE_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="订购完成进度(%)")
	@PostMapping("orderCompletion")
	public ResultResponse<BigDecimal> prizeCompletion() throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(userTargetPrizeService.prizeCompletion(getUserId()));
	}
	
}
