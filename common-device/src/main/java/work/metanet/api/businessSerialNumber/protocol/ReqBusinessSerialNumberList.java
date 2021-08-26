package work.metanet.api.businessSerialNumber.protocol;

import java.io.Serializable;

import work.metanet.api.businessSerialNumber.protocol.ReqBusinessSerialNumberInfo.RespBusinessSerialNumberInfo;
import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqBusinessSerialNumberList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	private String channelId;
	private String appId;
	private String businessSnCode;
	private String businessId;
	private String useStatus;
	private String startTime;
	private String endTime;
	private String remark;
	
    
    @EqualsAndHashCode(callSuper=true)
    @Accessors(chain = true)
    @Data
    public static class RespBusinessSerialNumberList extends RespBusinessSerialNumberInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String businessName;
    	private String channelName;
    	private String appName;
    	
    }
    

}
