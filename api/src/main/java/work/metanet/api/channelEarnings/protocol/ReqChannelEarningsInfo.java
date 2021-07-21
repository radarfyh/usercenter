package work.metanet.api.channelEarnings.protocol;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class ReqChannelEarningsInfo implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	private String channelEarningsId;
    
    @Accessors(chain = true)
    @Data
    public static class RespChannelEarningsInfo implements Serializable{
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String channelEarningsId;
    	private String month;
    	private BigDecimal orderPayTotalAmount;
    	private BigDecimal originalEarningsTotalAmount;
    	private BigDecimal actualEarningsTotalAmount;
    	private String remark;
        private String createTime;
        private String updateTime;
    }
    

}
