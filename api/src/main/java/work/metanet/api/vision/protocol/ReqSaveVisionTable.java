package work.metanet.api.vision.protocol;

import java.io.Serializable;

import work.metanet.model.VisionTableBase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @Description 视力表保存请求
 * @author EdisonFeng
 * @DateTime 2021年6月18日
 * Copyright(c) 2021. All Rights Reserved
 */
public class ReqSaveVisionTable extends VisionTableBase implements Serializable {

	private static final long serialVersionUID = 7423262760547290675L;
	@ApiModel("响应-保存测试表信息")
    @Accessors(chain = true)
    @Data
    public static class RespSaveVisionTable implements Serializable {
		private static final long serialVersionUID = -6333749763493130123L;

		/**
	     * 测试活动序列号
	     */	
		@ApiModelProperty(value = "测试表序列号", example = "e7e6dfb0a83911eb943f00ff71c9db07")
		private String id;
		
	    /**
	     * 测试距离（单位米）
	     */	
		@ApiModelProperty(value = "测试距离（单位米）", example = "2.0")
		private double distance;

		/**
	     * 行序号，从上数到下，0开始
	     */	
		@ApiModelProperty(value = "行序号，从上数到下，0开始", example = "0")
		private int lineSn;

    }
}
