package work.metanet.api.eyesArticle.protocol;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ReqRemoveEyesArticle implements Serializable{
	
	private static final long serialVersionUID = 72288590559616141L;
	
	@NotBlank(message = "文章id不能为空")
	@ApiModelProperty(example = "ffsjfisfnlle1011",required = true)
	private String eyesArticleId;

}
