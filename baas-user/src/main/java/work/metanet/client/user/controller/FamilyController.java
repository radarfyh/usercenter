package work.metanet.client.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.api.family.IFamilyMemberService;
import work.metanet.api.family.protocol.ReqFamilyMemberInfo;
import work.metanet.api.family.protocol.ReqFamilyMemberInfo.RespFamilyMemberInfo;
import work.metanet.api.family.protocol.ReqFamilyMemberList.RespFamilyMemberList;
import work.metanet.api.family.protocol.ReqGrowthRecord;
import work.metanet.api.family.protocol.ReqGrowthRecord.RespGrowthRecord;
import work.metanet.api.family.protocol.ReqRemoveFamilyMember;
import work.metanet.api.family.protocol.ReqSaveFamilyMember;
import work.metanet.api.family.protocol.ReqSaveFamilyMember.RespSaveFamilyMember;
import work.metanet.client.user.base.BaseController;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.server.usercenter.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"家庭"})
@RestController
@RequestMapping("api/family")
public class FamilyController extends BaseController{
	
	@DubboReference
	private MemberService memberSerivce;
	
	@ApiOperation(value="成长记录")
	@PostMapping("growthRecord")
	public ResultResponse<RespGrowthRecord> growthRecord(@Valid @RequestBody ReqGrowthRecord req) throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(memberSerivce.growthRecord(req.setUserId(getUserId())));
	}
	
	
	@ApiOperation(value="家庭成员列表")
	@PostMapping("familyMemberList")
	public ResultResponse<List<RespFamilyMemberList>> familyMemberList() throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(memberSerivce.familyMemberList(getUserId()));
	}
	
	
	@ApiOperation(value="家庭成员信息")
	@PostMapping("familyMemberInfo")
	public ResultResponse<RespFamilyMemberInfo> familyMemberInfo(@Valid @RequestBody ReqFamilyMemberInfo requestParam) throws Exception {
		return ResultResponseEnum.QUERY_SUCCESS.resultResponse(memberSerivce.familyMemberInfo(requestParam));
	}
	
	
	@ApiOperation(value="保存家庭成员")
	@PostMapping("saveFamilyMember")
	public ResultResponse<RespSaveFamilyMember> saveFamilyMember(@Valid @RequestBody ReqSaveFamilyMember requestParam) throws Exception {
		String userId = getUserId();
		requestParam.setCreateUser(userId).setUpdateUser(userId).setJoinUserId(userId);
		return ResultResponseEnum.CREATE_SUCCESS.resultResponse(memberSerivce.saveFamilyMember(requestParam));
	}
	
	@ApiOperation(value="删除家庭成员")
	@PostMapping("removeFamilyMember")
	public ResultResponse<?> removeFamilyMember(@Valid @RequestBody ReqRemoveFamilyMember requestParam) throws Exception {
		requestParam.setUserId(getUserId());
		memberSerivce.removeFamilyMember(requestParam);
		return ResultResponseEnum.MODIFY_SUCCESS.resultResponse();
	}
	
}
