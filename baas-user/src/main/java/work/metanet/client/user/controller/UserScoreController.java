package work.metanet.client.user.controller;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.userScore.IUserScoreService;
import work.metanet.api.userScore.protocol.ReqLearningChangeUserScore;
import work.metanet.api.userScoreDetail.IUserScoreDetailService;
import work.metanet.api.userScoreDetail.protocol.ReqAppUserScoreDetail;
import work.metanet.api.userScoreDetail.protocol.ReqAppUserScoreDetail.RespAppUserScoreDetail;
import work.metanet.api.userScoreExchange.IUserScoreExchangeService;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchange;
import work.metanet.client.user.base.BaseController;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.base.RespPaging;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"用户积分"})
@RestController
@RequestMapping("api/userScore")
public class UserScoreController extends BaseController{
	
	@DubboReference
	private IUserScoreService userScoreService;
	@DubboReference
	private IUserScoreExchangeService userScoreExchangeService;
	@DubboReference
	private IUserScoreDetailService userScoreDetailService;
	
	@ApiOperation(value="积分累积")
	@PostMapping("changeUserScore")
	public ResultResponse<?> learningChangeUserScore(@Valid @RequestBody ReqLearningChangeUserScore req) throws Exception {
		userScoreService.learningChangeUserScore(getUserId(), req);
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="兑换")
	@PostMapping("userScoreExchange")
	public ResultResponse<?> userScoreExchange(@Valid @RequestBody ReqUserScoreExchange req) throws Exception {
		userScoreExchangeService.userScoreExchange(getUserId(), req);
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="积分明细")
	@PostMapping("appUserScoreDetail")
	public ResultResponse<RespPaging<RespAppUserScoreDetail>> appUserScoreDetail(@Valid @RequestBody ReqAppUserScoreDetail req) throws Exception {
		req.setUserId(getUserId());
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(userScoreDetailService.appUserScoreDetail(req));
	}
	
}
