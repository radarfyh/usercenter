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

@ApiModel("请求-搜索资源")
@EqualsAndHashCode(callSuper=true)
@Data
public class ReqOpenSearchResource extends Paging implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "媒体类型(AUDIO:音频/VIDEO:视频/IMGBOOK:绘本)", required = true)
	@Pattern(regexp = "^(AUDIO|VIDEO|IMGBOOK)$", message = "媒体类型格式错误")
	@NotBlank(message = "媒体类型不能为空")
	private String mediaType;
	@ApiModelProperty(value = "关键字")
	private String keyword;
	@ApiModelProperty(value = "绘本类型(AMT:动画/ETC:电子/LVRD:分级阅读/GAME:游戏)")
	@Pattern(regexp = "^(AMT|ETC|LVRD|GAME|)$", message = "绘本类型格式错误")
	private String imgbookType;
	@ApiModelProperty(value = "年龄")
	private Integer minAge;
	@ApiModelProperty(value = "年龄")
	private Integer maxAge;
	@ApiModelProperty(value = "语言(cn/en)")
	@Pattern(regexp = "^(cn|en|)$", message = "语言格式错误")
	private String language;
	@ApiModelProperty(value = "是否排除混合语言(默认:false)")
	@NotNull(message = "是否排除混合语言不能为空")
	private Boolean excludeMixedLanguage = false;
	@ApiModelProperty(value = "主题")
	private String themeId;
	
	
	
}
