package work.metanet.api.questionnaire.protocol;

import work.metanet.model.QuestionnaireBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author edison
 * @Description 请求-保存调查表
 * @DateTime 2023年4月17日
 * Copyright(c) 2023. All Rights Reserved
 */
@Data
@Accessors
@ApiModel(value = "请求-保存调查表")
public class ReqSaveQuestionnaire extends QuestionnaireBase implements Serializable {

    private static final long serialVersionUID = 456781685L;

    @Data
    @Accessors
    @ApiModel(value = "响应-保存调查表")
    public static class RespSaveQuestionnaire implements Serializable {

        private static final long serialVersionUID = 80993209L;

        /**
         * 调查表序列号
         */
        @ApiModelProperty(value = "调查表序列号" ,example = "878c068db6da11eb8b765254006d7470")
        private String id;
    }
}

