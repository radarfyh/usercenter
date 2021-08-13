package work.metanet.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import work.metanet.base.HttpStatus;

@ToString
@Getter
@AllArgsConstructor
public enum ResultResponseEnum {
	QUERY_SUCCESS(HttpStatus.SC_OK, "查询成功", true),
	CREATE_SUCCESS(HttpStatus.SC_CREATED, "资源创建成功", true),
	MODIFY_SUCCESS(HttpStatus.SC_CREATED, "资源修改或者删除成功", true),
	AUTH_SUCCESS(210, "认证或者授权成功", true),
	UPLOAD_SUCCESS(211, "上传文件成功", true),

	INVALID_REQUEST(HttpStatus.SC_BAD_REQUEST, "请求无效，参数不正确，使用此代码需要替换本消息", false),
	ACCESS_DENIED(HttpStatus.SC_FORBIDDEN, "无访问权限", false),
	CONFLICT(HttpStatus.SC_CONFLICT, "资源标识冲突", false),
	DATA_FORMATTING_ERROR(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, "数据格式错误", false),
	
	FAILURE_DEVICE_NOT_ACTIVATE(1001,"设备未激活",false),
	FAILURE_DEVICE_DISABLE(1002,"设备已禁用",false),
	FAILURE_TIP_NOT_UPGRADE(1003,"暂无升级",false),
	
	FAILURE_AUTH_APPID(1004,"appId无效",false),
	
	FAILURE_AUTH_SIGN(1005,"非法篡改签名",false),
	FAILURE_AUTH_TIMESTAMP(1006,"请求已过期",false),
	FAILURE_AUTH_SIGN_SECRET(1007,"无效的签名",false),
	
	FAILURE_AUTH_USER_OVERDUE(1008,"登录已失效，请重新登录",false),
	FAILURE_AUTH_USER_LOGIN_OTHER_CLIENT(1009,"账号在其他设备登录",false),
	FAILURE_SESSION_TIMEOUT(1080,"会话已过期",false),
	FAILURE_LOGIN_OTHER(1081,"账号在其他地方登陆",false),
	
	FAILURE_REQUEST_HEADER(1083,"请求头信息错误",false),
	FAILURE_RECOGNITION_EMPTY(1100,"未识别到目标",false),
	
	FAILURE_OPENAPI_AUTH(2000, "token无效", false),
	FAILURE_OPENAPI_AUTH_24H_MAX_NUMBER(2001, "设备认证次数过多", false),
	FAILURE_OPENAPI_AUTH_SIGN_MAX_NUMBER(2002, "签约设备数已到达上限", false),
	FAILURE_OPENAPI_AUTH_OTHER_CLIENT(2003, "相同设备已在另一端认证", false),
	FAILURE_OPENAPI_AUTH_REFRESH_TOKEN(2004, "应使用刷新后的token", false),
	
	FAILURE_RPC(2100, "DUBBO RPC异常", false),
	FAILURE_RUNTIME(2110, "非RPC运行时异常", false),
	
	FAILURE_ACTIVATE(2120,"激活失败",false),
	
	FAILURE_GET_APP_OF_PACKAGE_NAME(2201,"获取包名对应的应用异常。",false),
	FAILURE_USER_NO_EXISTS(2202,"用户不存在",false),
	ERROR_OLD_PASSWORD(2203,"原密码错误",false),
	FAILURE_CHECK_CODE(2204,"验证校验码异常。",false),
	FAILURE_INIT_SCORE(2205,"初始化用户积分异常。",false),
	FAILURE_GET_TERMINAL_APPID(2206,"获取终端的应用ID异常。",false),
	FAILURE_GET_APP_VERSION(2207,"获取应用版本异常。",false),
	ERROR_USER_LOCKED(2208,"账号已被锁定",false),
	ERROR_USER_OR_PWD(2209,"用户名或密码错误",false),
	FAILURE_GET_PACKAGE_NAME(2210,"获取包名出错",false),
	ERROR_CODE(2211,"验证码错误",false),
	ERROR_INVALID_CODE(2212,"验证码已失效",false),
	ERROR_DISAGREE_PHONE_WITH_REGISTER(2213,"手机号码与注册时的手机号码不一致",false),
	FAILURE_GET_APP_LIST_OF_PARTNER(2214,"获取合作伙伴的应用列表异常。",false),
	
	SERVER_FAILURE(HttpStatus.SC_INTERNAL_SERVER_ERROR, "服务器故障（数据丢失、数据错误、未知BUG等等，使用此代码需要替换本消息）", false)	
    ;

	ResultResponseEnum(int code, String msg, boolean success) {
		this.responseCode = code;
		this.message = msg;
		this.successFlag = success;
	}

	@ApiModelProperty("成功标志")
	@NonNull
	private Boolean successFlag;
	
	@ApiModelProperty("响应码")
	@NonNull
	private Integer responseCode;
	
	@ApiModelProperty("返回消息")
	private String message;
	
	public <T> ResultResponse<T> resultResponse(){
		return new ResultResponse<T>(successFlag, responseCode, message, null, null);
	}
	
	public <T> ResultResponse<T> resultResponse(T t){ 
		return new ResultResponse<T>(successFlag, responseCode, message, t, null);
	}
	
	public <T> ResultResponse<T> resultResponse(T t, String token){ 
		return new ResultResponse<T>(successFlag, responseCode, message, t, token);
	}
}
