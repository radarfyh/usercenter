package work.metanet.api.businessSerialNumber.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-更新内容商激活码使用状态")
@Accessors(chain = true)
@Data
public class ReqUpdBusinessSnUseStatus implements Serializable{
	
	private static final long serialVersionUID = 5927667883245757418L;
	
	@ApiModelProperty(value = "内容商代码", required = true)
	@NotBlank(message = "内容商代码不能为空")
	private String businessCode;
	
	@ApiModelProperty(value = "内容商激活码", required = true)
	@NotBlank(message = "内容商激活码不能为空")
	private String businessSnCode;
	
	@ApiModelProperty(value = "使用状态(SUCCESS/FAIL/NO_USE)", required = true)
	@Pattern(regexp = "^(SUCCESS|FAIL|NO_USE)$", message = "使用状态格式错误")
	private String useStatus;

}
