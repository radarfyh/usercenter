/**
 * @Description 文件：ReqEyestrainList.java
 * @author EdisonFeng
 * @DateTime 2021年5月14日
 * Copyright(c) 2021. All Rights Reserved
 */
package work.metanet.api.vision.protocol;

import java.io.Serializable;

import work.metanet.api.vision.protocol.ReqEyestrainInfo.RespEyestrainInfo;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 请求类：用眼活动列表
 * @author EdisonFeng
 * @DateTime 2021年5月14日
 * Copyright(c) 2021. All Rights Reserved
 */
@ApiModel("请求-用眼活动列表")
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqEyestrainList extends Paging implements Serializable {

	private static final long serialVersionUID = 6912222101768302948L;

	@ApiModelProperty(value = "用眼类型（-1所有类型、0看书、1看屏幕、3其他", example = "0")
	private int useType;
	
	@ApiModelProperty(value = "用户序列号，关联用户信息", example = "e7e6dfb0a83911eb943f00ff71c9db07")
	private String userId;
	
    @ApiModel("响应-用眼活动列表")
    @EqualsAndHashCode(callSuper=true)
    @Accessors(chain = true)
    @Data
    public static class RespEyestrainList extends RespEyestrainInfo implements Serializable{

        @ApiModelProperty(value = "眼睛使用消耗时长")
        private int sumTimeDuration;

		private static final long serialVersionUID = -4328390943060433257L;
    }
}
