/**
 * @Description 文件：ReqVisionExerciseList.java
 * @author EdisonFeng
 * @DateTime 2021年5月17日
 * Copyright(c) 2021. All Rights Reserved
 */
package work.metanet.api.vision.protocol;

import work.metanet.base.Paging;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author nicely
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "请求-锻炼活动列表")
public class ReqVisionExerciseList extends Paging implements Serializable {
    private static final long serialVersionUID = 6912222101768302948L;

    @ApiModelProperty(value = "用户序列号", example = "2734086da3a945d5baef67b1f5f0041f")
    private String userId;

    @ApiModelProperty(value = "眼睛序列号", example = "0008bb79397c41cc9e9bed3f20008b2f")
    private String eyeId;

    @ApiModelProperty(value = "锻炼活动序列号（必填）", required = true, example = "9ebe30dbb77611eb8b765254006d7470")
    private String exerciseId;

    @ApiModelProperty(value = "锻炼类型（-1所有类型、0眼保健操、1眼肌锻炼、2眼球放松、3新型眼操、4其他），默认为0")
    private int exerciseType;

    @ApiModelProperty(value = "锻炼模式（-1所有模式，0自我监督模式，1家长协助模式，2医生协助模式），默认为0")
    private int exerciseMode;


    @ApiModel("响应-锻炼活动列表")
    @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @Data
    public static class RespVisionExerciseList extends ReqVisionExerciseInfo.RespVisionExerciseInfo implements Serializable {
        private static final long serialVersionUID = 1L;
    }

}
