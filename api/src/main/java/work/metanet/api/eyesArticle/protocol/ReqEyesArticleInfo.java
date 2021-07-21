package work.metanet.api.eyesArticle.protocol;

import work.metanet.model.EyesArticle;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Accessors(chain = true)
@Data
public class ReqEyesArticleInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "软文ID不能为空")
	@ApiModelProperty(example = "a7e439a7ee8b4c0a93f993423b8ea7af",required = true)
	private String eyesArticleId;
	
	@EqualsAndHashCode(callSuper=true)
	@Accessors(chain = true)
	@Data
	public static class RespEyesArticleInfo extends EyesArticle implements Serializable{
		private static final long serialVersionUID = 1L;
	}

}
