package work.metanet.api.permission;

import java.util.List;
import java.util.Map;

import work.metanet.api.permission.protocol.ReqPermissionInfo;
import work.metanet.api.permission.protocol.ReqPermissionInfo.RespPermissionInfo;
import work.metanet.api.permission.protocol.ReqPermissionList;
import work.metanet.api.permission.protocol.ReqPermissionList.RespPermissionList;
import work.metanet.api.permission.protocol.ReqRemovePermission;
import work.metanet.api.permission.protocol.ReqSavePermission;
import work.metanet.api.permission.protocol.ReqUpdPermissionParent;
import work.metanet.api.permission.vo.MenuVo;

public interface IPermissionService {

	/**
	 * @Description: 权限列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	List<RespPermissionList> permissionList(ReqPermissionList req) throws Exception;
	
	/**
	 * @Description: 权限详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespPermissionInfo permissionInfo(ReqPermissionInfo req) throws Exception;
	
	/**
	 * @Description: 保存权限
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void savePermission(ReqSavePermission req) throws Exception;
	
	/**
	 * @Description: 删除权限
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removePermission(List<ReqRemovePermission> req) throws Exception;
	
	/**
	 * @Description: 修改父级节点
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void updPermissionParent(List<ReqUpdPermissionParent> req) throws Exception;
	
	List<Map<String, Object>> permissionTree(String roleId) throws Exception;
	
	String adminPermissionApis(String adminId)throws Exception;
	
	String adminPermissionTags(String adminId)throws Exception;
	
	List<MenuVo> adminMenuList(String adminId)throws Exception;
	
}
