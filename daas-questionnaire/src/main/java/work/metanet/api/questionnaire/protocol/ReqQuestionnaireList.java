package work.metanet.api.questionnaire.protocol;

import com.fasterxml.jackson.annotation.JsonFormat;
import work.metanet.base.Paging;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author edison
 * @Description 请求-调查表列表
 * @DateTime 2023年4月17日
 * Copyright(c) 2023. All Rights Reserved
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "请求-调查表列表")
public class ReqQuestionnaireList extends Paging implements Serializable {
    private static final long serialVersionUID = 6912222101768302948L;

    @ApiModelProperty(value = "调查表名称" ,required = false , example = "2734086da3a945d5baef67b1f5f0041f")
    private String name;

    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @ApiModelProperty(value = "调查表开始时间，执行调查表所规定的活动的开始时间，也是首次提醒的时间点", example = "2021-05-01")
    private Date updateTime;

    @Data
    @Accessors(chain = true)
    @ApiModel(value = "响应-调查表列表")
    public static class RespQuestionnaireList extends ReqQuestionnaireInfo.RespQuestionnaireInfo implements Serializable{
        private static final long serialVersionUID = 2345678896790L;
    }

}

