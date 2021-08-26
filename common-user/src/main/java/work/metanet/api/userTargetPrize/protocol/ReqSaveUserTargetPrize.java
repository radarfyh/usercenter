package work.metanet.api.userTargetPrize.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("请求-保存用户订购")
@Data
public class ReqSaveUserTargetPrize implements Serializable{
	
	private static final long serialVersionUID = -8774473086300732709L;
	@ApiModelProperty(value = "商品id")
	@NotBlank(message = "商品id不能为空")
	private String prizeId;
	
}
