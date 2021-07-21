package work.metanet.api.eduResource.protocol;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel("请求-搜索资源")
@EqualsAndHashCode(callSuper=true)
@Data
public class ReqSearchResource extends Paging implements Serializable{
	
	private static final long serialVersionUID = 8892605421283471179L;
	@ApiModelProperty(value = "媒体类型-AUDIO/VIDEO/IMGBOOK", required = true)
	@Pattern(regexp = "^(AUDIO|VIDEO|IMGBOOK)$", message = "媒体类型格式错误")
	private String mediaType;
	@ApiModelProperty(value = "绘本类型(多个用逗号分隔)-AMT/ETC/LVRD/GAME")
	private String imgbookType;
	@ApiModelProperty(value = "关键字")
	private String keyword;
	@JsonIgnore
	private String userId;

}
