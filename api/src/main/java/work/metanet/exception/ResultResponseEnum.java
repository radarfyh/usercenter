package work.metanet.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum ResultResponseEnum {
	QUERY_SUCCESS(200, "查询成功", true),
	CREATE_SUCCESS(201, "资源创建成功", true),
	MODIFY_SUCCESS(204, "资源修改或者删除成功", true),
	AUTH_SUCCESS(207, "认证或者授权成功", true),
	UPLOAD_SUCCESS(208, "上传文件成功", true),

	INVALID_REQUEST(400, "请求无效，参数不正确，使用此代码需要替换本消息", false),
	ACCESS_DENIED(404, "无访问权限", false),
	CONFLICT(409, "资源标识冲突", false),
	DATA_FORMATTING_ERROR(415, "数据格式错误", false),
	
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
	FAILURE_RUNTIME(2110, "普通运行时异常", false),
	
	FAILURE_ACTIVATE(2120,"激活失败",false),
	
	SERVER_FAILURE(500, "服务器故障（数据丢失、数据错误、未知BUG等等，使用此代码需要替换本消息）", false)	
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
