package work.metanet.api.eduResource.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel("请求-资源明细列表")
@EqualsAndHashCode(callSuper=true)
@Data
public class ReqOpenEduResourceDetail extends Paging implements Serializable{
	
	private static final long serialVersionUID = 2330060591701837426L;
	@ApiModelProperty(value = "资源id",required = true)
	@NotBlank(message = "资源id不能为空")
	private String resourceId;
	@ApiModelProperty(value = "语言(cn/en)")
	@Pattern(regexp = "^(cn|en|)$", message = "语言格式错误")
	private String language;
	@ApiModelProperty(value = "是否排除混合语言(默认:false)")
	@NotNull(message = "是否排除混合语言不能为空")
	private Boolean excludeMixedLanguage = false;

}
