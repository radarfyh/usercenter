package work.metanet.api.eduResource.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("资源基础信息")
@Data
public class OpenEduResourceBaseVo implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "资源id")
	private String resourceId;
	@ApiModelProperty(value = "资源播放id")
	private String playId;
	@ApiModelProperty(value = "封面url")
	private String coverUrl;
	@ApiModelProperty(value = "文件")
	private String fileUrl;
	@ApiModelProperty(value = "标题")
	private String resourceTitle;
	@ApiModelProperty(value = "主题名称")
	private String themeName;
	@ApiModelProperty(value = "主题id(用于相同主题推荐)")
	private String themeId;
	@ApiModelProperty(value = "媒体类型(AUDIO:音频/VIDEO:视频/IMGBOOK:绘本)")
	private String mediaType;
	@ApiModelProperty(value = "绘本类型(AMT:动画/ETC:电子/LVRD:分级阅读/GAME:游戏)")
	private String imgbookType;
}
