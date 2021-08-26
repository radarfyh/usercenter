package work.metanet.api.eduResource.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-资源信息")
@Accessors(chain = true)
@Data
public class ReqEduResourceInfo implements Serializable{
	
	private static final long serialVersionUID = 8892605421283471179L;
	@ApiModelProperty(value = "资源id", required = true)
	@NotBlank(message = "资源id不能为空")
	private String resourceId;
	@JsonIgnore
	private String userId;

}
