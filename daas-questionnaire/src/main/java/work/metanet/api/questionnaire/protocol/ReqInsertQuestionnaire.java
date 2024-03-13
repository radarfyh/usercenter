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
 * @Description 请求-新增调查表
 * @DateTime 2023年4月17日
 * Copyright(c) 2023. All Rights Reserved
 */
@Data
@Accessors
@ApiModel("请求-新增调查表")
public class ReqInsertQuestionnaire extends QuestionnaireBase implements Serializable {

}

