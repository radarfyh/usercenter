package work.metanet.api.subject.protocol;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "请求-科目列表")
@Data
public class ReqSubjectList implements Serializable{
	
	private static final long serialVersionUID = -5232524211801154192L;
	
	@ApiModel(value = "响应-科目列表")
	@Data
	public static class RespSubjectList implements Serializable{
		
		private static final long serialVersionUID = 6508006755407317012L;
		@ApiModelProperty("科目id")
		private Integer subjectId;
		@ApiModelProperty("科目名称")
	    private String subjectName;
	}
	
}
