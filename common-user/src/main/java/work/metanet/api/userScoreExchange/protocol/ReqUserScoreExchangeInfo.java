package work.metanet.api.userScoreExchange.protocol;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReqUserScoreExchangeInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Data
	public static class RespUserScoreExchangeInfo implements Serializable{
		private static final long serialVersionUID = 1L;
		private String userScoreExchangeId;
		private String orderNumber;
		private String userId;
		private String prizeId;
		private String prizeName;
		private String prizeImg;
		private BigDecimal score;
		private String courierNumber;
		private String sendStatus;
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date sendTime;
		private String consignee;
		private String phone;
		private String province;
		private String city;
		private String county;
		private String address;
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date createTime;
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date updateTime;
		private String remark;
	}

}
