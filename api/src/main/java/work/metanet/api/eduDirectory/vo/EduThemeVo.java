package work.metanet.api.eduDirectory.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("主题")
@Data
public class EduThemeVo implements Serializable{
	
	private static final long serialVersionUID = 1544382675391570223L;
	@ApiModelProperty(value = "主题id")
	private String themeId;
	@ApiModelProperty(value = "主题名称")
	private String themeName;
	@ApiModelProperty(value = "序号")
	private Integer sort;
	
}
