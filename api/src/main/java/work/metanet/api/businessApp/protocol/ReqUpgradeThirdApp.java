package work.metanet.api.businessApp.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("请求-第三方APK升级")
@Data
public class ReqUpgradeThirdApp implements Serializable{
	
	private static final long serialVersionUID = 1483207692392961485L;
	
	@ApiModelProperty(value = "内容商代码" , required = true)
    @NotBlank(message = "内容商不能为空")
	private String businessCode;
	
	@ApiModelProperty(value = "包名" , required = true)
    @NotBlank(message = "包名不能为空")
	private String packageName;

}
