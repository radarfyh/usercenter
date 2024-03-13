
package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author edison
 * @Description 调查表
 * @DateTime 2023年4月17日
 * Copyright(c) 2023. All Rights Reserved
 */
@Data
@Accessors
public class QuestionnaireBase extends Base implements Serializable {
	/**
     * 记录ID
     */	
	@ApiModelProperty(value = "记录ID", example = "e7e6dfb0a83911eb943f00ff71c9db07")
	private String id;

	/**
	 * 调查表类型代码
	 */
	@ApiModelProperty(value = "调查表类型代码",example = "住院满意度调查表")
	private String typeCode;

	/**
     * 调查表名称（唯一）
     */	
	@ApiModelProperty(value = "调查表名称（唯一）", example = "八一骨科住院满意度调查表")
	private String name;

	/**
	 * 介绍
	 */
	@ApiModelProperty(value = "介绍", example = "本调查表起源于...，用于...请大家务必认真填写")
	private String introduction;

	/**
	 * 二维码链接
	 */
	@ApiModelProperty(value = "二维码链接", example = "/var/survey/qr")
	private String qrUrl;

	/**
	 * 总分
	 */
	@ApiModelProperty(value = "总分", example = "100")
	private int totalScore;


	/**
     * 创建者id
     */	
	@ApiModelProperty(value = "创建者id", example = "admin")
	private String createUser;
	
	/**
     * 修改者id
     */	
	@ApiModelProperty(value = "修改者id", example = "admin")
	private String updateUser;
}
