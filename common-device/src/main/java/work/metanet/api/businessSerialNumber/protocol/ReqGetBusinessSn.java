package work.metanet.api.businessSerialNumber.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-获取内容商激活码")
@Accessors(chain = true)
@Data
public class ReqGetBusinessSn implements Serializable{

	private static final long serialVersionUID = 2677870890135197673L;
	@ApiModelProperty(value = "内容商代码", required = true)
	@NotBlank(message = "内容商代码不能为空")
	private String businessCode;
	
	@ApiModelProperty(value = "激活码调用类型(SDK/APK)", required = true)
	@Pattern(regexp = "^(SDK|APK)$", message = "调用类型格式错误")
	private String callType;
	
	@ApiModel("响应-获取内容商激活码")
	@Data
	public static class RespGetBusinessSn implements Serializable{
		
		private static final long serialVersionUID = -175056064107318819L;
		@ApiModelProperty(value = "内容商代码")
		private String businessCode;
		
		@ApiModelProperty(value = "激活码调用类型", required = true)
		private String callType;
		
		@ApiModelProperty(value = "激活码/APPKEY")
		private String businessSnCode;
		
		@ApiModelProperty(value = "激活码引用标识符")
		private Boolean isOld = false;
		
	}
	
}