package work.metanet.api.eduResource.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("请求-推荐资源")
@Data
public class ReqOpenRecommendResource implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "媒体类型(AUDIO:音频/VIDEO:视频/IMGBOOK:绘本)", required = true)
	@Pattern(regexp = "^(AUDIO|VIDEO|IMGBOOK)$", message = "媒体类型格式错误")
	@NotBlank(message = "媒体类型不能为空")	
	private String mediaType;
	@ApiModelProperty(value = "推荐个数(1-20)", required = true)
	@Range(min = 1, max = 20,message = "推荐个数格式错误")
	@NotNull(message = "推荐个数不能为空")
	private Integer number;
	@ApiModelProperty(value = "语言(cn/en)")
	@Pattern(regexp = "^(cn|en|)$", message = "语言格式错误")
	private String language;
	@ApiModelProperty(value = "是否排除混合语言(默认:false)")
	@NotNull(message = "是否排除混合语言不能为空")
	private Boolean excludeMixedLanguage = false;
	@ApiModelProperty(value = "主题id(相同主题推荐)")
	private String themeId;
}
