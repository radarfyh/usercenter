package work.metanet.api.questionnaire.protocol;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author edison
 * @Description 请求-删除调查表
 * @DateTime 2023年4月17日
 * Copyright(c) 2023. All Rights Reserved
 */
@Data
@Accessors
@ApiModel(value = "请求-删除调查表")
public class ReqRemoveQuestionnaire implements Serializable {
    private static final long serialVersionUID = 96932835729L;

    @NotBlank(message = "调查表序列号不能为空")
    @ApiModelProperty(value = "调查表序列号",required = true , example = "878c068db6da11eb8b765254006d7470")
    private String id;
}

