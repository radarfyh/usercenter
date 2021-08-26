package work.metanet.api.fmreward.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("请求-新增奖励")
@Data
public class ReqAddReward implements Serializable{
	
	private static final long serialVersionUID = -8497885439750927087L;
	@ApiModelProperty(value = "资源id")
	@NotBlank(message = "资源id不能为空")
	private String resourceId;
	@ApiModelProperty(value = "奖励星星数")
	@NotNull(message = "奖励星星数不能为空")
	private Integer rewardNumber;
	
	@JsonIgnore
	private String userId;
	
}
