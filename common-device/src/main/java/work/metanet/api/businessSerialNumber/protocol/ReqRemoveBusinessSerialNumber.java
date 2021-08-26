package work.metanet.api.businessSerialNumber.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class ReqRemoveBusinessSerialNumber implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	@NotBlank(message = "内容商激活码Id不能为空")
    private String businessSerialNumberId;
	
    
    

}
