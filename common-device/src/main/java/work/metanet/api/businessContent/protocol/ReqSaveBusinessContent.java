package work.metanet.api.businessContent.protocol;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class ReqSaveBusinessContent implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	private String businessId;
	private String businessContentId;
	private String contentName;
	private String parentId;
	private String phase;
    private String remark;
	
    
	@EqualsAndHashCode(callSuper=true)
    @Accessors(chain = true)
    @Data
    public static class RespSaveBusinessContent extends ReqSaveBusinessContent implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	
    	
    	
    }
    

}
