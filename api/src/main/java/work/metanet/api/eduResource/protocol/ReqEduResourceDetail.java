package work.metanet.api.eduResource.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import work.metanet.api.eduResource.vo.EduResourceVo;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel("请求-资源详情")
@EqualsAndHashCode(callSuper=true)
@Data
public class ReqEduResourceDetail extends Paging implements Serializable{
	
	private static final long serialVersionUID = 2330060591701837426L;
	@ApiModelProperty(value = "资源id",required = true)
	@NotNull(message = "资源id不能为空")
	private String resourceId;
	
	@ApiModel("响应-资源详情")
	@EqualsAndHashCode(callSuper=true)
	@Data
	public static class RespEduResourceDetail extends EduResourceVo{
		private static final long serialVersionUID = -7744320416587620250L;
	}

}
