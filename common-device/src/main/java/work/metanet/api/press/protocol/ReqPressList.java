package work.metanet.api.press.protocol;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "请求-出版社列表")
@Data
public class ReqPressList implements Serializable{
	
	private static final long serialVersionUID = -5232524211801154192L;
	
	@ApiModel(value = "响应-出版社列表")
	@Data
	public static class RespPressList implements Serializable{
		
		private static final long serialVersionUID = 6508006755407317012L;
		@ApiModelProperty("出版社id")
		private Integer pressId;
		@ApiModelProperty("出版社名称")
	    private String pressName;
		@ApiModelProperty("出版社简称")
	    private String pressNameAbbr;
	}
	
}
