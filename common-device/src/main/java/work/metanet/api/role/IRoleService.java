package work.metanet.api.role;

import java.util.List;

import work.metanet.api.role.protocol.ReqRemoveRole;
import work.metanet.api.role.protocol.ReqRoleInfo;
import work.metanet.api.role.protocol.ReqRoleInfo.RespRoleInfo;
import work.metanet.api.role.protocol.ReqRoleList;
import work.metanet.api.role.protocol.ReqRoleList.RespRoleList;
import work.metanet.api.role.protocol.ReqSaveRole;
import work.metanet.base.RespPaging;

public interface IRoleService {

	/**
	 * @Description: 角色列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespPaging<RespRoleList> roleList(ReqRoleList req) throws Exception;
	
	/**
	 * @Description: 角色详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespRoleInfo roleInfo(ReqRoleInfo req) throws Exception;
	
	/**
	 * @Description: 保存角色
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void saveRole(ReqSaveRole req) throws Exception;
	
	/**
	 * @Description: 删除角色
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removeRole(List<ReqRemoveRole> req) throws Exception;
	
	
	/**
	 * @Description:配置管理员角色 
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/10
	 */
	int addAdminRole(String adminId,List<String> roleIdList);
	
	/**
	 * @Description: 获取管理员角色
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/03
	 */
	List<String> getRoleIdListByAdminId(String adminId);
	
	/**
	 * @Description: 删除管理员角色关联
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/18
	 */
	int removeAdminRole(String adminId);
	
}
