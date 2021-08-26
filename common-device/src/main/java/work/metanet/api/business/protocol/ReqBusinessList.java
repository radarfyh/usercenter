package work.metanet.api.business.protocol;

import java.io.Serializable;

import work.metanet.api.business.protocol.ReqBusinessInfo.RespBusinessInfo;
import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqBusinessList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	//模糊定位(like id|name)
	private String business;
	private String startTime;
	private String endTime;
	private String remark;
    
	@EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @Data
    public static class RespBusinessList extends RespBusinessInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    }
    

}
