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
@EqualsAndHashCode(callSuper=false)
public class ReqUpdateEyesArticle extends EyesArticle implements Serializable{
	@NotBlank(message = "ID 不能为空")
	@ApiModelProperty(example = "a7e439a7ee8b4c0a93f993423b8ea7af",required = true)
	private String eyesArticleId;
	private static final long serialVersionUID = 3456788965L;

}
