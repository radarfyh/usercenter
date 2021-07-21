package work.metanet.api.userScoreExchange.protocol;

import java.io.Serializable;

import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchangeInfo.RespUserScoreExchangeInfo;
import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqUserScoreExchangeList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String channelId;
	private String orderNumber;
	private String phone;
	private String courierNumber;
	private String sendStatus;
	private String startTime;
	private String endTime;
	private String remark;
	
	@EqualsAndHashCode(callSuper=true)
	@Data
	public static class RespUserScoreExchangeList extends RespUserScoreExchangeInfo implements Serializable{
		private static final long serialVersionUID = 1L;
		private String channelName;
	}
	
}
