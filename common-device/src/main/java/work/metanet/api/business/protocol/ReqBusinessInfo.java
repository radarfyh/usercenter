package work.metanet.api.business.protocol;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class ReqBusinessInfo implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	private String businessId;
    
    @Accessors(chain = true)
    @Data
    public static class RespBusinessInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String businessId;
    	private String businessCode;
        private String businessName;
        private String remark;
        private String createTime;
        
    }
    

}
