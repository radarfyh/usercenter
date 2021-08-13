package work.metanet.client.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.feedback.IFeedbackService;
import work.metanet.api.feedback.protocol.ReqAddFeedback;
import work.metanet.api.feedback.protocol.ReqGetFeedbackOption.RespGetFeedbackOption;
import work.metanet.client.user.base.BaseController;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"用户反馈"})
@RestController
@RequestMapping("api/feedback")
public class FeedbackController extends BaseController{
	
	@DubboReference
	private IFeedbackService feedbackOptionService;
	
	
	@ApiOperation(value="添加反馈")
	@PostMapping("addFeedback")
	public ResultResponse<?> addFeedback(@Valid @RequestBody ReqAddFeedback requestParam) throws Exception {
		feedbackOptionService.addFeedback(getUserId(),getPackageName(),getVersionCode(),requestParam);
		return ResultResponseEnum.CREATE_SUCCESS.resultResponse();
	}
	
	@ApiOperation(value="获取反馈选项")
	@PostMapping("getFeedbackOption")
	public ResultResponse<List<RespGetFeedbackOption>> getFeedbackOption() throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(feedbackOptionService.getFeedbackOption());
	}
	
}
