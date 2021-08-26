package work.metanet.client.user.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.client.user.base.BaseController;
import work.metanet.client.user.security.JwtAuthenticatioToken;
import work.metanet.client.user.security.SecurityUtils;
import work.metanet.exception.MetanetException;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;

import com.github.pagehelper.util.StringUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import work.metanet.server.usercenter.service.UsersService;
import work.metanet.utils.PasswordUtils;
import work.metanet.utils.token.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import work.metanet.api.app.IAppService;
import work.metanet.api.app.vo.AppVo;
import work.metanet.api.device.IDeviceService;
import work.metanet.api.deviceApp.IDeviceAppService;
import work.metanet.api.user.IUserLoginService;
import work.metanet.api.user.protocol.LoginBean;
import work.metanet.api.user.protocol.ReqCheckCode;
import work.metanet.api.user.protocol.ReqLoginSuper;
import work.metanet.api.user.protocol.ReqLogin.RespLogin;
import work.metanet.api.version.IAppVersionService;
import work.metanet.api.version.vo.AppVersionVo;
import work.metanet.base.UserToken;
import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.utils.IOUtils;
import work.metanet.utils.CosUtil;
import work.metanet.utils.HttpResult;

/**
 * login登录控制器
 * @author Louis & Edison
 * @date 2020/1/9
 */
@Api(tags = "登录")
@RestController
public class LoginController extends BaseController {
	@DubboReference
	private UsersService usersService;
	@DubboReference
	private IDeviceService deviceService;
	@DubboReference
	private IAppService appService;
	@DubboReference
	private IAppVersionService appVersionService;
	@DubboReference
	private IDeviceAppService deviceAppService;
	@DubboReference
	private IUserLoginService userLoginService;
	
	@Autowired
	private CosUtil cosUtil;
	
	@Autowired
	private Producer producer;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@ApiOperation(value="获取验证码图片")
	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		// 保存到验证码到 session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);	
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录接口
	 */
	@ApiOperation(value="带图片验证码登录")
	@PostMapping(value = "/login")
	public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
		String username = loginBean.getAccount();
		String password = loginBean.getPassword();
		String captcha = loginBean.getCaptcha();
		
		// 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
		Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(kaptcha == null){
			return HttpResult.error("验证码已失效");
		}
		if(!captcha.equals(kaptcha)){
			return HttpResult.error("验证码不正确");
		}
		
		// 用户信息
		UcUsers user = usersService.findByName(username);

		// 账号不存在、密码错误
		if (user == null) {
			return HttpResult.error("账号不存在");
		}
		
		if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error("密码不正确");
		}

		// 账号锁定
		if (!user.getStatus()) {
			return HttpResult.error("账号已被锁定,请联系管理员");
		}

		// 系统登录认证
		JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
				
		return HttpResult.ok(token);
	}
	
	@ApiOperation(value="APP登录")
	@PostMapping("loginApp")
	public ResultResponse<RespLogin> loginApp(@Valid @RequestBody ReqLoginSuper requestParam) throws Exception {
		
		AppVo appVo = null;
		String appId = null;
		String packageName = getPackageName();
		String versionCode = getVersionCode();
	 	String deviceId = requestParam.getDeviceId();
	 	if (StringUtil.isEmpty(deviceId)) deviceId = getDeviceId();

		//短信验证码
		ReqCheckCode checkCode = new ReqCheckCode();
		BeanUtil.copyProperties(requestParam, checkCode);
		usersService.checkCode(null, checkCode);

		// 获取appid
		try {
			appVo = appService.getAppByPackageName(packageName);
		} catch (Exception e) {
			throw MetanetException.of().setMsg("获取包名对应的应用异常。" + e.getMessage());
		}
		if (BeanUtil.isNotEmpty(appVo)) {
			appId = appVo.getAppId();
			if (StringUtil.isNotEmpty(appId)) {
				if (!appId.equals(getAppId())) {
					// 根据包名获取的appid不等于上传的包头appid
				}
			} else {
				appId = getAppId();
			}
		}

		// 获取用户ID
		UcUsers user = usersService.getUser(appId, packageName, deviceId, versionCode, requestParam);
		
		if(user==null)
			throw MetanetException.of(ResultResponseEnum.ERROR_USER_OR_PWD.resultResponse());
		if(!user.getEnableStatus())
			throw MetanetException.of(ResultResponseEnum.ERROR_USER_LOCKED.resultResponse());
		String userId = user.getId();
		String userName = user.getUsername();
		
		// 获取版本ID
		AppVersionVo appVersionVo;
		try {
			appVersionVo = appVersionService.getAppVersion(packageName, versionCode);
		} catch (Exception e) {
			throw MetanetException.of().setMsg("获取应用版本异常。" + e.getMessage());
		}
		String versionId = appVersionVo.getVersionId();

	 	//登录日志记录
	 	userLoginService.loginRecord(userId, deviceId, versionId);

		// 获取设备的appid
	 	String deviceAppId;
		try {
			deviceAppId = deviceAppService.getDeviceAppId(deviceId, packageName);
		} catch (Exception e) {
			throw MetanetException.of().setMsg("获取终端的应用ID异常。" + e.getMessage());
		}
	 	
	 	//生成token(阶段一过期时间限制拉长,实际是需要采用短期刷新token方案)
	 	UserToken userToken = new UserToken(deviceAppId, deviceId, appId, userId, userName, false);
	 	String token = TokenUtil.generateToken(JSONUtil.toJsonStr(userToken), 60*60*24*365L);
		
		//更新用户token
	 	usersService.cacheUserToken(userId, token);
		
	 	//返回对象构建
		RespLogin resp = new RespLogin();
		BeanUtil.copyProperties(user, resp);
		resp.setToken(token);
		resp.setHeadUrl(cosUtil.getAccessUrl(resp.getHeadUrl()));
		
		return ResultResponseEnum.AUTH_SUCCESS.resultResponse(resp);
	}
}
