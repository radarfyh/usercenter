package work.metanet.api.fmbrowse.protocol;

import java.io.Serializable;

import work.metanet.api.eduResource.vo.EduResourceVo;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@ApiModel("请求-资源浏览记录列表")
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqFmBrowseList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 1988758773260384144L;
	
	@ApiModel("响应-资源浏览记录列表")
	@EqualsAndHashCode(callSuper=true)
	@Data
	public static class RespFmBrowseList extends EduResourceVo{
		private static final long serialVersionUID = 7669685419516957954L;
		@ApiModelProperty(value = "浏览记录id")
		private String fmBrowseId;
		@ApiModelProperty(value = "播放占比%")
		private Double ratio;
		
	}
	
}
