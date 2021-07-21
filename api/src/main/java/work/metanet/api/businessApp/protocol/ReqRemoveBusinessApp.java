package work.metanet.api.businessApp.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ReqRemoveBusinessApp implements Serializable{
	
	private static final long serialVersionUID = -3227451593613708414L;
	
	@NotBlank(message = "内容商产品id不能为空")
	private String businessAppId;

}
