package work.metanet.api.eduResource.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel("资源详情")
@EqualsAndHashCode(callSuper=true)
@Data
public class OpenEduResourceInfoVo extends OpenEduResourceBaseVo implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "简介")
	private String introduction;
	@ApiModelProperty(value = "内容")
	private String content;
	@ApiModelProperty(value = "总数")
	private String total;
}
