package work.metanet.exception;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@ApiModel("响应结果")
@Data
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultResponse<T> implements Serializable {

	private static final long serialVersionUID = 9116316697422169833L;
	
	@ApiModelProperty("成功标志")
	@NonNull
	private Boolean successFlag;
	
	@ApiModelProperty("响应码")
	@NonNull
	private Integer responseCode;
	
	@ApiModelProperty("返回消息")
	@NonNull
	private String message;
	
	@ApiModelProperty("返回数据")
	private T data;
	
	@ApiModelProperty("返回令牌")
	private String token;

}
