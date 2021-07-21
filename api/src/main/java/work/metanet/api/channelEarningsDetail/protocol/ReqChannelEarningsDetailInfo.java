package work.metanet.api.channelEarningsDetail.protocol;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class ReqChannelEarningsDetailInfo implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	private String channelEarningsDetailId;
    
    @Accessors(chain = true)
    @Data
    public static class RespChannelEarningsDetailInfo implements Serializable{
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String channelEarningsDetailId;
    	private String channelEarningsId;
    	private String month;
    	private String orderNumber;
    	private String orderPayTime;
    	private BigDecimal orderPayAmount;
    	private BigDecimal originalEarningsAmount;
    	private Double settlementRatio;
    	private BigDecimal actualEarningsAmount;
    	private String remark;
        private String createTime;
        private String updateTime;
    }
    

}
