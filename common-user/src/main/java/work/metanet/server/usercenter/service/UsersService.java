package work.metanet.server.usercenter.service;

import java.util.List;
import java.util.Set;

import work.metanet.server.usercenter.domain.UcDepartments;
import work.metanet.server.usercenter.domain.UcRoles;
import work.metanet.server.usercenter.domain.UcUserDept;
import work.metanet.server.usercenter.domain.UcUserRole;
import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.api.user.protocol.ReqAccountCancel;
import work.metanet.api.user.protocol.ReqCheckCode;
import work.metanet.api.user.protocol.ReqLoginSuper;
import work.metanet.api.user.protocol.ReqRegister;
import work.metanet.api.user.protocol.ReqRemoveUser;
import work.metanet.api.user.protocol.ReqResetPassword;
import work.metanet.api.user.protocol.ReqSendCode;
import work.metanet.api.user.protocol.ReqUpdPassword;
import work.metanet.api.user.protocol.ReqUpdUser;
import work.metanet.api.user.protocol.ReqUserList;
import work.metanet.api.user.protocol.ReqLogin.RespLogin;
import work.metanet.api.user.protocol.ReqUserInfo.RespUserInfo;
import work.metanet.api.user.protocol.ReqUserList.RespUserList;
import work.metanet.base.RespPaging;
import work.metanet.base.service.CurdService;
import work.metanet.exception.MetanetException;


/**
 * user管理
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
public interface UsersService extends CurdService<UcUsers> {

	UcUsers findByName(String username) throws MetanetException;

	/**
	 * 查找用户的菜单权限标识集合
	 * @param userName
	 * @return
	 */
	Set<String> findPermissions(String userName) throws MetanetException;

	/**
	 * 查找用户角色关系集合
	 * @param userId
	 * @return
	 */
	List<UcUserRole> findUserRoles(String userId) throws MetanetException;
	
	/**
	 * 查找角色集合
	 * @param userId
	 * @return
	 */
	List<UcRoles> findRoles(String userId) throws MetanetException;
	
	/**
	 * 查找用户部门关系集合
	 * @param userId
	 * @return
	 */
	List<UcUserDept> findUserDepts(String userId) throws MetanetException;
	
	/**
	 * 查找部门集合
	 * @param userId
	 * @return
	 */
	List<UcDepartments> findDepts(String userId) throws MetanetException;
	
	
//	Integer userTotal(String channelId) throws MetanetException;
	
	String cacheUserToken(String userId) throws MetanetException;
	
	void cacheUserToken(String userId,String token)throws MetanetException;
	
	Boolean hashUserTokenKey(String userId) throws MetanetException;

	/**
	 * @Description: 发送手机验证码
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/12
	 */
	void sendCode(String packageName,ReqSendCode requestParam) throws MetanetException;
	
	
	/**
	 * @Description: 确认验证码
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/12/03
	 */
	void checkCode(String userId,ReqCheckCode requestParam) throws MetanetException;
	
	/**
	 * @Description: 注册
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/12
	 */
	void register(String packageName,ReqRegister requestParam) throws MetanetException;
	void register(ReqRegister requestParam) throws MetanetException;
	
	/**
	 * @Description: 登录
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/12
	 */
//	RespLogin login(UserVo userVo,String deviceId,String packageName,String versionCode) throws MetanetException;
	
	RespLogin procLoginReq(UcUsers user, String deviceId, String appId, String versionId
			, String deviceAppId) throws MetanetException;
	
	/**
	 * @Description: 登录与注册
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/12
	 */
//	RespLogin loginSuper(String deviceId,String packageName,String versionCode,ReqLoginSuper requestParam) throws MetanetException;

	UcUsers getUser(String appId, String packageName, String deviceId
			, String versionCode, ReqLoginSuper requestParam) throws MetanetException;
	
	/**
	 * @Description: 修改用户信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/12
	 */
	void updUser(String userId,ReqUpdUser requestParam) throws MetanetException;
	
	/**
	 * @Description: 获取用户信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/12
	 */
	RespUserInfo userInfo(String userId) throws MetanetException;

	/**
	 * @Description: 修改密码
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/12
	 */
	void updPassword(String userId,ReqUpdPassword requestParam) throws MetanetException;
	
	/**
	 * @Description: 重置密码
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/17
	 */
	void resetPassword(String userId,ReqResetPassword requestParam) throws MetanetException;
	
	/**
	 * @Description: 用户列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/14
	 */
	RespPaging<RespUserList> userList(ReqUserList requestParam) throws MetanetException;
	
	/**
	 * @Description: 删除用户
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removeUser(List<ReqRemoveUser> req) throws MetanetException;
	
	/**
	 * @Description: 退出登录
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/05
	 */
	void logout(String userId) throws MetanetException;
	
	/**
	 * @Description: 销户
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/09
	 */
	void accountCancel(String userId,ReqAccountCancel req) throws MetanetException;
	
	
	/**
	 * @Description: 使用第三方的电话号码创建新用户
	 * @Author Edison F.
	 * @DateTime 2021/07/26
	 */
	String syncUser(String appId, String phone) throws MetanetException;
	
}
