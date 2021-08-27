package work.metanet.api.family;

import java.util.List;

import work.metanet.api.family.protocol.ReqFamilyMemberInfo;
import work.metanet.api.family.protocol.ReqGrowthRecord;
import work.metanet.api.family.protocol.ReqFamilyMemberInfo.RespFamilyMemberInfo;
import work.metanet.api.family.protocol.ReqFamilyMemberList.RespFamilyMemberList;
import work.metanet.api.family.protocol.ReqGrowthRecord.RespGrowthRecord;
import work.metanet.api.family.protocol.ReqRemoveFamilyMember;
import work.metanet.api.family.protocol.ReqSaveFamilyMember;
import work.metanet.api.family.protocol.ReqSaveFamilyMember.RespSaveFamilyMember;

public interface IFamilyMemberService {
	
	/**
	 * @Description: 成长记录
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/08/27
	 */
	RespGrowthRecord growthRecord(ReqGrowthRecord req)throws Exception;

	/**
	 * @Description: 家庭成员列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	List<RespFamilyMemberList> familyMemberList(String joinUserId) throws Exception;
	
	/**
	 * @Description: 获取家庭成员信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespFamilyMemberInfo familyMemberInfo(ReqFamilyMemberInfo req) throws Exception;
	
	/**
	 * @Description: 保存家庭成员信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespSaveFamilyMember saveFamilyMember(ReqSaveFamilyMember req) throws Exception;
	
	/**
	 * @Description: 删除家庭成员
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removeFamilyMember(ReqRemoveFamilyMember req) throws Exception;
	
}
