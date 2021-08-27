package work.metanet.api.eyesArticle.protocol;

import work.metanet.model.EyesArticle;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
public class ReqInsertEyesArticle extends EyesArticle implements Serializable {

    private static final long serialVersionUID = 72288590559616141L;
    /*@NotBlank(message = "")
    private String eyesArticleId;*/
    @NotBlank(message = "标题不能为空")
    @ApiModelProperty(value = "标题",required = true,example = "如何科学养猪")
    private String eyesArticleTitle;
    @NotBlank(message = "类型不能为空")
    @ApiModelProperty(value = "类型：文章:ARTICLE/视频:VIDEO",required = true,example = "ARTICLE")
    private String eyesArticleType;
    private String eyesArticleImg;
    private String eyesArticleUrl;
    private String remark;

    @Data
    @Accessors(chain = true)
    public class RespInsertEyesArticle implements Serializable{

        private static final long serialVersionUID = 72288590559616141L;

    }
}
