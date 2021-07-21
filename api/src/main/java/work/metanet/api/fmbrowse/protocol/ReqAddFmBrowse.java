package work.metanet.api.fmbrowse.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-新增浏览记录")
@Accessors(chain = true)
@Data
public class ReqAddFmBrowse implements Serializable{
	
	private static final long serialVersionUID = -365985277696777383L;
	
	@ApiModelProperty(value = "资源id")
	@NotBlank(message = "资源id不能为空")
	private String resourceId;
	
	@ApiModelProperty(value = "播放占比")
	private Double ratio = 0.0;

}
