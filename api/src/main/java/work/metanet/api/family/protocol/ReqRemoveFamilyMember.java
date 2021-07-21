package work.metanet.api.family.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-删除家庭成员")
@Accessors(chain = true)
@Data
public class ReqRemoveFamilyMember implements Serializable{

	private static final long serialVersionUID = 5448598344020657643L;
	
	@ApiModelProperty(value = "家庭成员id", required = true)
	@NotBlank(message = "家庭成员id不能为空")
	private String familyMemberId;
	
	@JsonIgnore
	private String userId;

}
