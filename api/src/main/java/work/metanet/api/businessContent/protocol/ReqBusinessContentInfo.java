package work.metanet.api.businessContent.protocol;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class ReqBusinessContentInfo implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	private String businessContentId;
    
    @Accessors(chain = true)
    @Data
    public static class RespBusinessContentInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String businessId;
    	private String businessContentId;
    	private String contentName;
    	private String parentId;
    	private String phase;
        private String remark;
        private String createTime;
    	
    	
    }
    

}
