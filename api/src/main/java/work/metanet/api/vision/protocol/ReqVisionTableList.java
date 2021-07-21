
package work.metanet.api.vision.protocol;

import java.io.Serializable;
import work.metanet.api.vision.protocol.ReqVisionTableInfo.RespVisionTableInfo;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 请求：视力表清单查询
 * @author EdisonFeng
 * @DateTime 2021年6月18日
 * Copyright(c) 2021. All Rights Reserved
 */
@ApiModel("请求-视力表列表")
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqVisionTableList extends Paging implements Serializable {
	private static final long serialVersionUID = -1721386371533002306L;
	
    /**
     * 类型 0近视力表 1远视力表
     */	
	@ApiModelProperty(value = "类型 0近视力表 1远视力表", example = "0")
	private int tableType;
	
    /**
     * 测试距离（单位米）
     */	
	@ApiModelProperty(value = "测试距离（单位米）", example = "5.0")
	private double distance;
    
    @ApiModel("响应-视力表列表")
    @EqualsAndHashCode(callSuper=true)
    @Accessors(chain = true)
    @Data
    public static class RespVisionTableList extends RespVisionTableInfo implements Serializable{
		private static final long serialVersionUID = 3090749741528252867L;
    }
}
