package work.metanet.api.channelEarnings.protocol;

import java.io.Serializable;

import work.metanet.api.channelEarnings.protocol.ReqChannelEarningsInfo.RespChannelEarningsInfo;
import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqChannelEarningsList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	private String channelId;
	private String month;
    private String remark;
    private String startTime;
	private String endTime;
	
	@EqualsAndHashCode(callSuper=true)
    @Accessors(chain = true)
    @Data
    public static class RespChannelEarningsList extends RespChannelEarningsInfo implements Serializable{
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String channelName;
    	private String appName;
    	private Integer detailTotal;
    }
    

}
