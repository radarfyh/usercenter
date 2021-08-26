package work.metanet.api.eduResource.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("资源信息")
@Data
public class EduResourceVo implements Serializable{
	private static final long serialVersionUID = -7744320416587620250L;
	@ApiModelProperty(value = "资源id")
	private String resourceId;
	@ApiModelProperty(value = "内容商代码")
	private String businessCode;
	@ApiModelProperty(value = "资源类型-RESOURCE/PAGE")
	private String resourceType;
	@ApiModelProperty(value = "第三方id")
	private String thirdId;
	@ApiModelProperty(value = "标题")
	private String resourceTitle;
	@ApiModelProperty(value = "简介")
	private String introduction;
	@ApiModelProperty(value = "内容")
	private String content;
	@ApiModelProperty(value = "媒体类型-AUDIO音频/VIDEO视频/IMGBOOK绘本")
	private String mediaType;
	@ApiModelProperty(value = "绘本类型-AMT动画/ETC电子/LVRD分级阅读/GAME游戏")
	private String imgbookType;
	@ApiModelProperty(value = "封面url")
	private String coverUrl;
	@ApiModelProperty(value = "文件")
	private String fileUrl;
	@ApiModelProperty(value = "主题名称")
	private String themeName;
	@ApiModelProperty(value = "主题id")
	private String themeId;
	@ApiModelProperty(value = "总集数-搜索音频时显示")
	private String total;
	@ApiModelProperty(value = "收藏标识")
	private boolean collect;
}
