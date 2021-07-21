package work.metanet.api.eduResource.protocol;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel("请求-推荐资源")
@EqualsAndHashCode(callSuper=true)
@Data
public class ReqRecommendResource extends Paging implements Serializable{
	
	private static final long serialVersionUID = 8892605421283471179L;
	@ApiModelProperty(value = "媒体类型-AUDIO/VIDEO/IMGBOOK", required = true)
	@Pattern(regexp = "^(AUDIO|VIDEO|IMGBOOK)$", message = "媒体类型格式错误")
	private String mediaType;
	@ApiModelProperty(value = "绘本类型-AMT动画/ETC电子/LVRD分级阅读/GAME游戏")
	private String imgbookType;
	@ApiModelProperty(value = "年龄")
	private Integer minAge;
	@ApiModelProperty(value = "年龄")
	private Integer maxAge;
	@ApiModelProperty(value = "语言")
	private String language;
	@ApiModelProperty(value = "主题")
	private String themeId;
	@ApiModelProperty(value = "是否随机获取")
	private Boolean random = false;
	@JsonIgnore
	private String userId;

}
