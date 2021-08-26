package work.metanet.api.openAppBusiness.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-开放平台业务KEY")
@Accessors(chain = true)
@Data
public class ReqOpenAppBusinessKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "业务代码", required = true)
	@NotBlank(message = "业务代码不能为空")
	private String businessCode;
	
	@ApiModel("响应-开放平台业务KEY")
	@Accessors(chain = true)
	@Data
	public static class RespOpenAppBusinessKey implements Serializable{	
		private static final long serialVersionUID = 1L;
		@ApiModelProperty("业务KEY")
		private String businessKey;
		@ApiModelProperty("业务SECRET")
		private String businessSecret;
	}

}
