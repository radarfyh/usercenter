package work.metanet.api.business.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ReqRemoveBusiness implements Serializable{
	
	private static final long serialVersionUID = -3227451593613708414L;
	
	@NotBlank(message = "内容商id不能为空")
	private String businessId;

}
