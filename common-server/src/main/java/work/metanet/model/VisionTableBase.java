package work.metanet.model;

import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author EdisonFeng
 * @Description 类VisonTableBase, Model：t_vision_table 的基类
 * @DateTime 2021年4月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper=false)
public class VisionTableBase extends Base {
    /**
     * 序列号（修改时必需）
     */	
	@ApiModelProperty(value = "序列号（修改时必需）", example = "a5835d19a83c11eb943f00ff71c9db07")
	@Id
	private String id;
	
    /**
     * 类型 0近视力表 1远视力表
     */	
	@ApiModelProperty(value = "类型 0近视力表 1远视力表", example = "0")
	private int tableType;

	/**
     * 行序号，从上数到下，0开始
     */	
	@ApiModelProperty(required = true, value = "行序号，从上数到下，0开始", example = "0")
	private int lineSn;
	
    /**
     * 测试距离
     */	
	@ApiModelProperty(value = "测试距离", example = "5.0")
	private double distance;
	
	/**
     * 小数记录
     */	
	@ApiModelProperty(value = "小数记录", example = "0.8")
	private double decimalRecord;
	
    /**
     * 对数记录，5分制
     */	
	@ApiModelProperty(value = "对数记录，5分制", example = "4.9")
	private double logarithmRecord;
	
    /**
     * 视标边长，单位豪米
     */	
	@ApiModelProperty(value = "视标边长，单位豪米", example = "4.9")
	private double sightingMarkLength;
}
