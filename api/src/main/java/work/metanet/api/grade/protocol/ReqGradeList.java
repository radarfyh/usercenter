package work.metanet.api.grade.protocol;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "请求-年级列表")
@Data
public class ReqGradeList implements Serializable{
	
	private static final long serialVersionUID = -5232524211801154192L;
	
	@ApiModel(value = "响应-年级列表")
	@Data
	public static class RespGradeList implements Serializable{
		
		private static final long serialVersionUID = 6508006755407317012L;
		@ApiModelProperty("年级id")
		private Integer gradeId;
		@ApiModelProperty("年级id")
	    private String gradeName;
	}

}
