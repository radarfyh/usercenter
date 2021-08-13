package work.metanet.client.user.controller;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.prize.IPrizeService;
import work.metanet.api.prize.protocol.ReqPrizeStore;
import work.metanet.api.prize.protocol.ReqPrizeStore.RespPrizeStore;
import work.metanet.client.user.base.BaseController;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.base.RespPaging;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"商品"})
@RestController
@RequestMapping("api/product")
public class ProductController extends BaseController{
	
	@DubboReference
	private IPrizeService prizeService;
	
	@ApiOperation(value="商品列表")
	@PostMapping("productStore")
	public ResultResponse<RespPaging<RespPrizeStore>> prizeStore(@Valid @RequestBody ReqPrizeStore req) throws Exception {
		req.setPackageName(getPackageName());
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(prizeService.prizeStore(req));
	}
	
}
