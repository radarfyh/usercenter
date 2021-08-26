package work.metanet.api.businessApp.protocol;

import java.io.Serializable;

import work.metanet.api.businessApp.protocol.ReqBusinessAppInfo.RespBusinessAppInfo;
import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqBusinessAppList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	private String businessId;
	private String appName;
	private String packageName;
	private String versionCode;
	private String startTime;
	private String endTime;
	private String remark;
    
	@EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @Data
    public static class RespBusinessAppList extends RespBusinessAppInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	
    }
    

}
