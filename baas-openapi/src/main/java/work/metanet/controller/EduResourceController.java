package work.metanet.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.eduDirectory.protocol.ReqEduCondition;
import work.metanet.api.eduDirectory.protocol.ReqEduCondition.RespEduCondition;
import work.metanet.api.eduResource.IEduConditionService;
import work.metanet.api.eduResource.IOpenEduResourceService;
import work.metanet.api.eduResource.protocol.ReqOpenEduResourceDetail;
import work.metanet.api.eduResource.protocol.ReqOpenEduResourceInfo;
import work.metanet.api.eduResource.protocol.ReqOpenRecommendResource;
import work.metanet.api.eduResource.protocol.ReqOpenSearchResource;
import work.metanet.api.eduResource.vo.OpenEduResourceBaseVo;
import work.metanet.api.eduResource.vo.OpenEduResourceInfoVo;
import work.metanet.base.RespPaging;
import work.metanet.base.Result;
import work.metanet.base.ResultMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"学习资源"})
@RestController
@RequestMapping("api/eduResource")
public class EduResourceController extends BaseController{
	
	@DubboReference
	private IEduConditionService eduConditionService;
	@DubboReference
	private IOpenEduResourceService openEduResourceService;
	
	@ApiOperation(value="筛选条件")
	@PostMapping("eduCondition")
	public Result<List<RespEduCondition>> eduCondition(@Valid @RequestBody ReqEduCondition req) throws Exception {
		return ResultMessage.SUCCESS.result(eduConditionService.eduConditionDynamicAll(req));
	}
	
	@ApiOperation(value="推荐资源")
	@PostMapping("recommendResource")
	public Result<List<OpenEduResourceBaseVo>> recommendResource(@Valid @RequestBody ReqOpenRecommendResource req) throws Exception {
		return ResultMessage.SUCCESS.result(openEduResourceService.recommendResource(req));
	}
	
	@ApiOperation(value="资源搜索")
	@PostMapping("searchResource")
	public Result<RespPaging<OpenEduResourceBaseVo>> searchResource(@Valid @RequestBody ReqOpenSearchResource req) throws Exception {
		return ResultMessage.SUCCESS.result(openEduResourceService.searchResource(req));
	}
	
	@ApiOperation(value="资源详情")
	@PostMapping("eduResourceInfo")
	public Result<OpenEduResourceInfoVo> eduResourceInfo(@Valid @RequestBody ReqOpenEduResourceInfo req) throws Exception {
		return ResultMessage.SUCCESS.result(openEduResourceService.eduResourceInfo(req));
	}
	
	@ApiOperation(value="资源明细列表")
	@PostMapping("eduResourceDetail")
	public Result<RespPaging<OpenEduResourceInfoVo>> eduResourceDetail(@Valid @RequestBody ReqOpenEduResourceDetail req) throws Exception {
		return ResultMessage.SUCCESS.result(openEduResourceService.eduResourceDetail(req));
	}
	
	
}
