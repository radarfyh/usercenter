package work.metanet.api.businessContent.protocol;

import java.io.Serializable;

import work.metanet.api.businessContent.protocol.ReqBusinessContentInfo.RespBusinessContentInfo;
import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqBusinessContentList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	private String businessId;
	private String contentName;
	private String parentId;
	private String phase;
	private String remark;
    
	@EqualsAndHashCode(callSuper=true)
    @Accessors(chain = true)
    @Data
    public static class RespBusinessContentList extends RespBusinessContentInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String businessName;
    	private String parentConentName;
    	private Boolean open;
    	
    	
    }
    

}
