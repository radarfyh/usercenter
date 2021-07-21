package work.metanet.api.businessApp.protocol;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class ReqBusinessAppInfo implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	private String businessAppId;
    
    @Accessors(chain = true)
    @Data
    public static class RespBusinessAppInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String businessAppId;
    	private String businessId;
    	private String businessName;
    	private String appName;
    	private String packageName;
    	private String versionCode;
    	private String appUrl;
        private String remark;
        private String instruction;
        private String createTime;
        
    }
    

}
