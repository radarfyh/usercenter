package work.metanet.server.usercenter.service.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import work.metanet.base.page.MyPageHelper;
import work.metanet.server.usercenter.repository.DeptsRepository;
import work.metanet.server.usercenter.repository.RolesRepository;
import work.metanet.server.usercenter.repository.UserDeptRepository;
import work.metanet.server.usercenter.repository.UserRoleRepository;
import work.metanet.server.usercenter.repository.UsersRepository;
import work.metanet.server.usercenter.service.ResourcesService;
import work.metanet.server.usercenter.service.LoginService;
import work.metanet.server.usercenter.service.ScoreService;
import work.metanet.server.usercenter.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.constant.ConstCacheKey;
import work.metanet.constant.ConstSmsRequestType;
import work.metanet.constant.Constant;
import work.metanet.constant.SysConstants;
import work.metanet.exception.MetanetException;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.util.sms.SmsUtil;
import work.metanet.web.utils.CosUtil;
import work.metanet.utils.token.TokenUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;

import work.metanet.server.usercenter.domain.UcDepartments;
import work.metanet.server.usercenter.domain.UcResources;
import work.metanet.server.usercenter.domain.UcRoles;
import work.metanet.server.usercenter.domain.UcUserDept;
import work.metanet.server.usercenter.domain.UcUserRole;
import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.api.user.protocol.ReqAccountCancel;
import work.metanet.api.user.protocol.ReqCheckCode;
import work.metanet.api.user.protocol.ReqLogin.RespLogin;
import work.metanet.api.user.protocol.ReqLoginSuper;
import work.metanet.api.user.protocol.ReqRegister;
import work.metanet.api.user.protocol.ReqRemoveUser;
import work.metanet.api.user.protocol.ReqResetPassword;
import work.metanet.api.user.protocol.ReqSendCode;
import work.metanet.api.user.protocol.ReqUpdPassword;
import work.metanet.api.user.protocol.ReqUpdUser;
import work.metanet.api.user.protocol.ReqUserInfo.RespUserInfo;
import work.metanet.api.user.protocol.ReqUserList;
import work.metanet.api.user.protocol.ReqUserList.RespUserList;
import work.metanet.base.UserToken;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.base.RespPaging;

/**
 * user管理
 * @author Louis & Edison
 * @date 2020/1/9
 */
@DubboService
@RefreshScope
public class UsersServiceImpl implements UsersService {
	//protected final Log logger = LogFactory.getLog(getClass());
	private static Logger log = LogManager.getLogger(UsersServiceImpl.class);
	
	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private ResourcesService resourcesService;
	@Autowired
	private RolesRepository rolesRepo;
	@Autowired
	private UserDeptRepository userDeptRepo;
	@Autowired
	private UserRoleRepository userRoleRepo;
	@Autowired
	private DeptsRepository deptsRepo;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private SmsUtil smsUtil;

	@Autowired
	private CosUtil cosUtil;

	@Autowired
	private LoginService userLoginService;
	@Autowired
	private ScoreService userScoreService;
	@Autowired
	private Constant constant;

	@Override
	public int delete(String id) throws MetanetException {
		usersRepo.deleteById(id);
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<UcUsers> findAllSort(Sort sort) throws MetanetException {
		List<UcUsers> list = usersRepo.findAll(sort);
		Iterator<UcUsers> iterator = list.iterator();
		return (Iterable<UcUsers>) iterator;
	}

	@Override
	public Page<UcUsers> findAll(Pageable page) throws MetanetException {
		return usersRepo.findAll(page);
	}

	@Override
	public int add(UcUsers record) throws MetanetException {
		if (usersRepo.save(record) == null) {
			return -1;
		}
		return 0;
	}

	@Override
	public int update(String id, UcUsers record) throws MetanetException {
		if (!usersRepo.findById(id).isPresent()) {
			return -1;
		}
		UcUsers newUser = new UcUsers();
		BeanUtil.copyProperties(record, newUser);
		newUser.setId(id);
		if (usersRepo.save(newUser) == null) {
			return -1;
		}

		return 0;
	}

	@Override
	public int update(UcUsers record) throws MetanetException {
		if (usersRepo.save(record) == null) {
			return -1;
		}
		return 0;
	}


	@Override
	public List<UcDepartments> findDepts(String userId) throws MetanetException {
		
		List<UcDepartments> departments = new ArrayList<>();
		
		List<UcUserDept> userDepts = findUserDepts(userId);
		
		for(Iterator<UcUserDept> iter=userDepts.iterator(); iter.hasNext();) {
			UcUserDept userDept = iter.next();
			//Departments department = sysDeptMapper.selectByPrimaryKey(userDept.getDeptId());
			Optional<UcDepartments> department = deptsRepo.findById(userDept.getDeptId());
			if(!department.isPresent()) {
				continue ;
			}
			departments.add(department.get());
		}
		return departments;
	}

	@Override
	public List<UcRoles> findRoles(String userId) throws MetanetException {
		List<UcRoles> roles = new ArrayList<>();
		
		List<UcUserRole> userRoles = findUserRoles(userId);
		
		for(Iterator<UcUserRole> iter=userRoles.iterator(); iter.hasNext();) {
			UcUserRole userRole = iter.next();
			Optional<UcRoles> role = rolesRepo.findById(userRole.getRoleId());
			if(!role.isPresent()) {
				continue ;
			}
			roles.add(role.get());
		}
		return roles;
	}

	@Override
	public List<UcUserDept> findUserDepts(String userId) throws MetanetException {
		
		return userDeptRepo.findByUserId(userId);
	}
	
	@Override
	public List<UcUserRole> findUserRoles(String userId) throws MetanetException {
		return userRoleRepo.findByUserId(userId);
	}
	
	@Transactional
	@Override
	public int save(UcUsers record) throws MetanetException {
		String id = null;
		if(record.getId() == null || record.getId().isEmpty()) {
			// 新增用户
			usersRepo.save(record);
			
			id = record.getId();
		} else {
			// 更新用户信息
			usersRepo.save(record);
		}
		
		if(id != null && id.isEmpty()) {
			return SysConstants.SUCCUSS;
		}
		
		// 更新用户角色关系
		if(id != null) {
			for(UcUserRole userRole:record.getUserRoles()) {
				userRole.setUserId(id);
			}
		} else {
			userRoleRepo.deleteByUserId(record.getId());
		}
		for(UcUserRole userRole:record.getUserRoles()) {
			userRoleRepo.save(userRole);
		}
		
		// 更新用户部门关系
		if(id != null) {
			for(UcUserDept userDept:record.getUserDepts()) {
				userDept.setUserId(id);
			}
		} else {
			userDeptRepo.deleteByUserId(record.getId());
		}
		for(UcUserDept userDept:record.getUserDepts()) {
			userDeptRepo.save(userDept);
		}

		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(UcUsers record) throws MetanetException {
		usersRepo.deleteById(record.getId());
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(List<UcUsers> records) throws MetanetException {
		for(UcUsers record:records) {
			delete(record);
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public UcUsers findById(String id) throws MetanetException {
		Optional<UcUsers> user = usersRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}

		return null;
	}
	
	@Override
	public UcUsers findByName(String name) throws MetanetException {
		List<UcUsers> users = usersRepo.findByUsername(name);
		if (users.size() > 0) {
			//调试信息
			UcUsers first = new UcUsers();
			BeanUtil.copyProperties(users.get(0), first);
			
//			log.log(Level.forName("NOTICE", 450), 
//					"userid:" + first.getId() + " username:" + first.getUsername());
			
//			if (BeanUtil.isEmpty(first.getAddresses())) {
//				Set<UcUserAddresses> addressess = new HashSet<UcUserAddresses>(); 
//				addressess.clear();
//				first.setAddresses(addressess);
//			}
//			if (first.getAddresses().size() > 0) {
//				log.log(Level.forName("NOTICE", 450),  " address:" + first.getAddresses().iterator().next().getEmailAddress());
//			}
			return first;
		}

		return null;
	}
	
	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) throws MetanetException {
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageRequest.toJSON());
		
		Page<UcUsers> result = null;
		String name = MyPageHelper.getColumnFilterValue(pageRequest, "username");
		String email = MyPageHelper.getColumnFilterValue(pageRequest, "email");
		//调试信息
		log.log(Level.forName("NOTICE", 450), "name: " + name);		
		if(name != null && !name.isEmpty()) {
			if(email != null && !email.isEmpty()) {
				Sort sort = Sort.by(Sort.Direction.DESC, "username", "email");
				Pageable page = PageRequest.of(pageRequest.getPageNum() - 1, pageRequest.getPageSize(), sort);
				result = usersRepo.findByUsernameAndEmail(name, email, page);
			} else {
				Sort sort = Sort.by(Sort.Direction.DESC, "username");
				Pageable page = PageRequest.of(pageRequest.getPageNum() - 1, pageRequest.getPageSize(), sort);
				//调试信息
				log.log(Level.forName("NOTICE", 450), 
						"result = usersRepo.findByUsername(name, page); name: "+name);
				result = usersRepo.findByUsername(name, page);
			}
		} else {
			Sort sort = Sort.by(Sort.Direction.DESC, "username");
			Pageable page = PageRequest.of(pageRequest.getPageNum() - 1, pageRequest.getPageSize(), sort);
			result = usersRepo.findAll(page);
		}
				
		// 转换格式
		MyPageResult pageResult = MyPageHelper.getPageResult(result);
        
		// 加载用户角色信息
		findUserRoles(pageResult);
		// 加载部门信息
		findUserDepts(pageResult);
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageResult.toJSON());

		return pageResult;
	}

	
	/**
	 * 加载用户角色
	 * @param pageResult
	 */
	private void findUserRoles(MyPageResult pageResult) throws MetanetException {
		List<?> content = pageResult.getContent();
		for(Object object:content) {
			UcUsers user = (UcUsers) object;
			
			List<UcUserRole> userRoles = findUserRoles(user.getId());
			user.setUserRoles(userRoles);
			user.setRoleNames(getRoleNames(userRoles));
			
			List<UcRoles> roles = findRoles(user.getId());
			user.setRoles(roles);
		}
	}

	private String getRoleNames(List<UcUserRole> userRoles) throws MetanetException {
		StringBuilder sb = new StringBuilder();
		for(Iterator<UcUserRole> iter=userRoles.iterator(); iter.hasNext();) {
			UcUserRole userRole = iter.next();
			Optional<UcRoles> role = rolesRepo.findById(userRole.getRoleId());
			if(!role.isPresent()) {
				continue ;
			}
			sb.append(role.get().getName());
			if(iter.hasNext()) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	/**
	 * 加载用户部门
	 * @param pageResult
	 */
	private void findUserDepts(MyPageResult pageResult) throws MetanetException {
		List<?> content = pageResult.getContent();
		for(Object object:content) {
			UcUsers user = (UcUsers) object;
			List<UcDepartments> departments = findDepts(user.getId());
			user.setDepartments(departments);
			
			if(departments.isEmpty()) {
				continue;
			}
			// 获取第一个部门的id，并修改用户关联信息
			user.setDeptId(departments.get(0).getId());
			// 获取部门名称，以逗号分隔
			StringBuilder sb = new StringBuilder();
			for(UcDepartments dept:departments) {
				if(dept == null) {
					continue;
				}
				if(sb.length() == 0) {
					sb.append(dept.getName());
				}
				else {
					sb.append("," + dept.getName());
				}
			}
			user.setDeptName(sb.toString());
		}
	}


	
	@Override
	public Set<String> findPermissions(String userName) throws MetanetException {	
		Set<String> perms = new HashSet<>();
		List<UcResources> menus = resourcesService.findByUser(userName);
		for(UcResources menu:menus) {
			if(menu.getPerms() != null && !"".equals(menu.getPerms())) {
				perms.add(menu.getPerms());
			}
		}
		//输出调试信息
        log.log(Level.forName("NOTICE", 450),perms);
		
		return perms;
	}
	

	@Override
	public String cacheUserToken(String userId) throws MetanetException {
		return stringRedisTemplate.opsForValue().get(ConstCacheKey.USER_TOKEN.cacheKey(userId));
	}
	
	@Override
	public void cacheUserToken(String userId, String token) throws MetanetException {
		stringRedisTemplate.opsForValue().set(ConstCacheKey.USER_TOKEN.cacheKey(userId), token, Duration.ofSeconds(ConstCacheKey.USER_TOKEN.getExpire()));
	}
	
	@Override
	public Boolean hashUserTokenKey(String userId) throws MetanetException {
		String cacheKey = ConstCacheKey.USER_TOKEN.cacheKey(userId);
        return stringRedisTemplate.hasKey(cacheKey);
	}
	
	@Override
	public void sendCode(String packageName, ReqSendCode req) throws MetanetException {
		String validateCode = RandomUtil.randomString(constant.getRandom_base_number(), 4);
		ConstSmsRequestType smsRequestType = ConstSmsRequestType.setSmsType(req.getSmsType());
		String sign = Convert.toStr(stringRedisTemplate.opsForHash().get(ConstCacheKey.APP_SMS_SIGN.cacheKey(), packageName));
		//异步发送短信验证码
		smsUtil.sendSms(sign, smsRequestType, req.getPhone(), validateCode);
		String cachekey = ConstCacheKey.SMS.cacheKey(smsRequestType.name(),req.getPhone());
		stringRedisTemplate.opsForValue().set(cachekey, validateCode, Duration.ofSeconds(ConstCacheKey.SMS.getExpire()));
	}
	
	
	@Override
	public void checkCode(String userId, ReqCheckCode requestParam) throws MetanetException {
		try {
			validationCode(userId,requestParam.getPhone(),requestParam.getCode(),ConstSmsRequestType.setSmsType(requestParam.getSmsType()));
		} catch (Exception e) {
			throw MetanetException.of().setMsg("验证校验码异常。" + e.getMessage());
		}
	}
	
	
	private void validationCode(String userId,String phone,String code,ConstSmsRequestType constSmsRequestType) throws Exception{
		if(constSmsRequestType==ConstSmsRequestType.CHANGE_PASSWORD) {
			Optional<UcUsers> user = usersRepo.findById(userId);
			if(!user.isPresent()) {
				throw MetanetException.of().setMsg("用户不存在");		
			}
			if(!user.get().getPhone().equals(phone)) {
				throw MetanetException.of().setMsg("手机号码与注册时的手机号码不一致");
			}
		}
		String cachekey = ConstCacheKey.SMS.cacheKey(constSmsRequestType.name(),phone);
		String cacheCode = stringRedisTemplate.opsForValue().get(cachekey);
		if(StringUtils.isEmpty(cacheCode)) 
			throw MetanetException.of().setMsg("验证码已失效");
		if(!cacheCode.equals(code)) 
			throw MetanetException.of().setMsg("验证码错误");
		stringRedisTemplate.delete(cachekey);
	}
	
	@Override
	public void register(ReqRegister requestParam) throws MetanetException {
		String packageName = "work.metanet.intrest_group";
		register(packageName, requestParam);
	}
	
	@Override
	public void register(String appId, ReqRegister requestParam) throws MetanetException {
		UcUsers user = new UcUsers();
		user.setAppId(appId);
		user.setUsername(requestParam.getUsername());
		user.setPassword(SecureUtil.md5(requestParam.getPassword()));
		user.setPhone(requestParam.getPhone());
		user.setNickName(requestParam.getNickName());
		if(StringUtils.isEmpty(user.getNickName())) {
			user.setNickName(user.getPhone().substring(user.getPhone().length()-6,user.getPhone().length()));			
		}
		usersRepo.save(user);
	}
	
	@Override
	public RespLogin procLoginReq(UcUsers user, String deviceId, String appId, String versionId
			, String deviceAppId) throws MetanetException {
	 	
	 	//登录记录
	 	userLoginService.loginRecord(user.getId(), deviceId, versionId);
	 	
	 	//生成token(阶段一过期时间限制拉长,实际是需要采用短期刷新token方案)
	 	UserToken userToken = new UserToken(deviceAppId, deviceId, appId, user.getId(), user.getUsername(),false);
	 	String token = TokenUtil.generateToken(JSONUtil.toJsonStr(userToken), 60*60*24*365L);
		
		//更新用户token
		cacheUserToken(user.getId(), token);
		
		RespLogin resp = new RespLogin();
		BeanUtil.copyProperties(user, resp);
		resp.setToken(token);
		resp.setHeadUrl(cosUtil.getAccessUrl(resp.getHeadUrl()));
		
		return resp;
	}
	
	@Override
	public UcUsers getUser(String appId, String packageName, String deviceId
			, String versionCode, ReqLoginSuper requestParam) throws MetanetException {

		UcUsers user = usersRepo.getUser(appId, null, requestParam.getPhone(), null, null);
		
		if(user == null) {
			if(StringUtils.isEmpty(requestParam.getPassword())) throw MetanetException.of().setMsg("请输入密码");
			//注册
			String phone = requestParam.getPhone();
			user = new UcUsers();
			user.setAppId(appId);
			user.setUsername(phone);
			user.setPassword(SecureUtil.md5(requestParam.getPassword()));
			user.setPhone(phone);
			user.setNickName(phone.substring(phone.length()-6, phone.length()));
			user.setEnableStatus(true);
			usersRepo.save(user);
			//初始化用户积分
			try {
				userScoreService.initUserScore(user.getId());
			} catch (Exception e) {
				throw MetanetException.of().setMsg("初始化用户积分异常。" + e.getMessage());
			}
		}

		return user;
	}
	
	@Override 
	public void updUser(String userId, ReqUpdUser requestParam) throws MetanetException {
		Optional<UcUsers> user = usersRepo.findById(userId);
		if(!user.isPresent()) {
			throw MetanetException.of(ResultResponseEnum.FAILURE_USER_NO_EXISTS.resultResponse());
		}
		
		BeanUtil.copyProperties(requestParam, user, CopyOptions.create().ignoreNullValue());
		user.get().setHeadUrl(cosUtil.filterUrlDomain(user.get().getHeadUrl()));
		usersRepo.save(user.get());
	}
	
	@Override
	public RespUserInfo userInfo(String userId) throws MetanetException {
		Optional<UcUsers> user = usersRepo.findById(userId);
		if(!user.isPresent()) {
			throw MetanetException.of(ResultResponseEnum.FAILURE_USER_NO_EXISTS.resultResponse());
		}
		
		RespUserInfo respUserInfo = new RespUserInfo();
		BeanUtil.copyProperties(user.get(), respUserInfo);
		respUserInfo.setHeadUrl(cosUtil.getAccessUrl(respUserInfo.getHeadUrl()));
  		return respUserInfo;
	}

	@Override
	public void updPassword(String userId, ReqUpdPassword requestParam) throws MetanetException {
		Optional<UcUsers> user = usersRepo.findById(userId);
		if(!user.isPresent()) {
			throw MetanetException.of(ResultResponseEnum.FAILURE_USER_NO_EXISTS.resultResponse());	
		}
		
		if(!user.get().getPassword().equals(SecureUtil.md5(requestParam.getPassword())))
			throw MetanetException.of(ResultResponseEnum.ERROR_OLD_PASSWORD.resultResponse());
		user.get().setPassword(SecureUtil.md5(requestParam.getNewPassword()));
		usersRepo.save(user.get());
	}
	
	
	@Override
	public void resetPassword(String userId, ReqResetPassword requestParam) throws MetanetException {
		try {
			validationCode(userId, requestParam.getPhone(), requestParam.getCode(),
					ConstSmsRequestType.CHANGE_PASSWORD);
		} catch (Exception e) {
			throw MetanetException.of().setMsg("校验验证码异常。" + e.getMessage());
		}

		Optional<UcUsers> user = usersRepo.findById(userId);
		if(!user.isPresent()) {
			throw MetanetException.of(ResultResponseEnum.FAILURE_USER_NO_EXISTS.resultResponse());	
		}
		
		user.get().setPassword(SecureUtil.md5(requestParam.getNewPassword()));
		usersRepo.save(user.get());
	}
	
	
	@Override 
	public RespPaging<RespUserList> userList(ReqUserList requestParam) throws MetanetException {
		RespPaging<RespUserList> respPaging = new RespPaging<RespUserList>();
		PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
		
		List<RespUserList> dbUsers = usersRepo.getUserList(requestParam.getChannelId(), requestParam.getUser(), 
				requestParam.getAppId(), requestParam.getDevice(), 
				requestParam.getStartTime(), requestParam.getEndTime(), 
				requestParam.getEnableStatus(), requestParam.getRemark());
		
		BeanUtil.copyProperties(new PageInfo<RespUserList>(dbUsers), respPaging);
		
		return respPaging; 
	}
	
	/**
	 * @Description: 删除用户
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	@Override
	public void removeUser(List<ReqRemoveUser> req) throws MetanetException {
		usersRepo.removeUser(req);
	}
	
	/**
	 * @Description: 退出登录
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/05
	 */
	@Async
	@Override
	public void logout(String userId) throws MetanetException {
		stringRedisTemplate.delete(ConstCacheKey.USER_TOKEN.cacheKey(userId));
	}
	
	/**
	 * @Description: 销户
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/09
	 */
	@Override
	public void accountCancel(String userId, ReqAccountCancel req) throws MetanetException {
		Optional<UcUsers> user = usersRepo.findById(userId);
		if(!user.isPresent()) {
			throw MetanetException.of(ResultResponseEnum.FAILURE_USER_NO_EXISTS.resultResponse());		
		}
		
		try {
			validationCode(null, user.get().getPhone(), req.getCode(), ConstSmsRequestType.ACCOUNT_CANCEL);
		} catch (Exception e) {
			throw MetanetException.of().setMsg("验证校验码异常。" + e.getMessage());
		}
		
		usersRepo.removeUser(CollUtil.newArrayList(new ReqRemoveUser().setUserId(userId)));
	}
	
	@Override
	public String syncUser(String appId, String phone) throws MetanetException {
		
		UcUsers user = new UcUsers().setAppId(appId).setPhone(phone);
		user.setStatus(true);
		
		Optional<UcUsers> dbUser = usersRepo.findFirstByAppIdAndPhone(appId, phone);
		if(!dbUser.isPresent()) {
			UcUsers newUser = new UcUsers()
					.setAppId(appId)
					.setPhone(phone)
					.setUsername(phone)
					.setPassword(SecureUtil.md5("0000"))
					.setNickName(phone.substring(phone.length()-6,phone.length()))
					.setEnableStatus(true)
					;
			usersRepo.save(newUser);
			return newUser.getId();
		}
		return dbUser.get().getId();
	}
	

}
