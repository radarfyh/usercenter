package work.metanet.api.channelEarningsDetail.protocol;

import java.io.Serializable;

import work.metanet.api.channelEarningsDetail.protocol.ReqChannelEarningsDetailInfo.RespChannelEarningsDetailInfo;
import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqChannelEarningsDetailList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	private String channelEarningsId;
	private String appId;
	private String thirdBusinessId;
	private String username;
    private String orderNumber;
    private String orderPayStartTime;
    private String orderPayEndTime;
    private String remark;
    private String startTime;
	private String endTime;
	
	@EqualsAndHashCode(callSuper=true)
    @Accessors(chain = true)
    @Data
    public static class RespChannelEarningsDetailList extends RespChannelEarningsDetailInfo implements Serializable{
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String channelName;
    	private String appName;
    	private String thirdBusinessName;
    	private String username;
    }
    

}
