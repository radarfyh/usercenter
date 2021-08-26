
package work.metanet.api.vision.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 请求：移除视力表
 * @author EdisonFeng
 * @DateTime 2021年6月18日
 * Copyright(c) 2021. All Rights Reserved
 */
public class ReqRemoveVisionTable implements Serializable {

	private static final long serialVersionUID = 6806666985657537983L;
	
	@ApiModelProperty(value = "id,UUID", required = true, example = "d62c4636ada84022be827c63d3c89fed")
	@NotBlank(message = "ID不能为空")
    private String id;
}
