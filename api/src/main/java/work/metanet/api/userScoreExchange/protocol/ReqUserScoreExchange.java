package work.metanet.api.userScoreExchange.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-用户积分兑换")
@Accessors(chain = true)
@Data
public class ReqUserScoreExchange implements Serializable{
	
	private static final long serialVersionUID = 8861838759440264965L;
	@ApiModelProperty(value = "商品id",required = true)
	@NotBlank(message = "商品id不能为空")
	private String prizeId;
	@ApiModelProperty(value = "收货人",required = true)
	@NotBlank(message = "收货人不能为空")
    private String consignee;
	@ApiModelProperty(value = "电话号码",required = true)
	@NotBlank(message = "电话号码不能为空")
    private String phone;
	@ApiModelProperty(value = "省",required = true)
	@NotBlank(message = "省不能为空")
    private String province;
	@ApiModelProperty(value = "市",required = true)
	@NotBlank(message = "市不能为空")
    private String city;
	@ApiModelProperty(value = "县",required = true)
	@NotBlank(message = "县不能为空")
    private String county;
	@ApiModelProperty(value = "收货地址",required = true)
	@NotBlank(message = "收货地址不能为空")
    private String address;
	@ApiModelProperty(value = "邮编")
    private String zipCode;

}
