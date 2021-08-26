package work.metanet.api.fmcollect.protocol;

import java.io.Serializable;

import work.metanet.api.eduResource.vo.EduResourceVo;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@ApiModel("请求-资源收藏列表")
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqFmCollectList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 1988758773260384144L;
	
	@ApiModel("响应-资源收藏列表")
	@EqualsAndHashCode(callSuper=true)
	@Data
	public static class RespFmCollectList extends EduResourceVo{
		private static final long serialVersionUID = 7669685419516957954L;
		@ApiModelProperty(value = "收藏记录id")
		private String fmCollectId;
	}
	
}
