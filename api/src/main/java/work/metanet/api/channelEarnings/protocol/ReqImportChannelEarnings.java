package work.metanet.api.channelEarnings.protocol;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class ReqImportChannelEarnings implements Serializable{
	
	private static final long serialVersionUID = 478287614852354005L;
	private String month;
	private String thirdBusinessCode;
	private String userId;
	private String orderNumber;
	private String orderPayTime;
	private BigDecimal orderPayAmount;
	private BigDecimal originalEarningsAmount;
	
}
