package work.metanet.api.eduDirectory.protocol;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-筛选条件")
@Accessors(chain = true)
@Data
public class ReqEduCondition implements Serializable{
	
	private static final long serialVersionUID = 3931739857828790395L;
	@ApiModelProperty(value = "媒体类型(AUDIO:音频/VIDEO:视频/IMGBOOK:绘本)", required = true)
	@Pattern(regexp = "^(AUDIO|VIDEO|IMGBOOK)$", message = "媒体类型格式错误")
	private String mediaType;
	
	@ApiModel("响应-筛选条件类型")
	@Accessors(chain = true)
	@Data
	public static class RespEduCondition implements Serializable{
		private static final long serialVersionUID = 814560965697774056L;
		private String type;
		private List<RespEduConditionKV> list;
	}
	
	@ApiModel("响应-年龄条件键值列表")
	@Accessors(chain = true)
	@Data
	public static class RespEduConditionKV implements Serializable{
		private static final long serialVersionUID = 5647226111503998893L;
		private String key;
		private String val;
	}

}
