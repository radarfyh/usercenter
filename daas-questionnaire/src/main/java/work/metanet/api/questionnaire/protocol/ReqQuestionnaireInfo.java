package work.metanet.api.questionnaire.protocol;

import work.metanet.model.QuestionnaireBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author edison
 * @Description 请求-调查表详情
 * @DateTime 2023年4月17日
 * Copyright(c) 2023. All Rights Reserved
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "请求-调查表详情")
public class ReqQuestionnaireInfo implements Serializable {

    @NotBlank(message = "调查表序列号不能为空")
    @ApiModelProperty(value = "调查表Id",required = true , example = "878c068db6da11eb8b765254006d7470")
    private String id;

    @ApiModelProperty(value = "调查表名称" ,required = false , example = "2734086da3a945d5baef67b1f5f0041f")
    private String name;

    @Data
    @Accessors(chain = true)
    @ApiModel(value = "响应-调查表详情")
    public static class RespQuestionnaireInfo extends QuestionnaireBase implements Serializable {
        private static final long serialVersionUID = 1L;
    }
}

