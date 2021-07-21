package work.metanet.api.openAppBusiness.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class ReqOpenAppBusinessSave implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	private String openAppBusinessId;
	@NotBlank
	private String appId;
	@NotBlank
	private String channelId;
	@NotBlank
	private String businessName;
	@NotBlank
	private String businessCode;
	@NotBlank
	private String businessKey;
	private String businessSecret;
	private String remark;

}
