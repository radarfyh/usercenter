package work.metanet.api.userTargetPrize.protocol;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-用户目标奖品信息")
@Data
public class ReqUserTargetPrizeInfo implements Serializable{
	
	private static final long serialVersionUID = -8774473086300732709L;
	
	@ApiModel("响应-用户目标奖品信息")
	@Accessors(chain = true)
	@Data
	public static class RespUserTargetPrizeInfo implements Serializable {
		private static final long serialVersionUID = -3515353127548774538L;
		@ApiModelProperty(value = "奖品id")
		private String prizeId;
		@ApiModelProperty(value = "奖品名称")
		private String prizeName;
		@ApiModelProperty(value = "奖品图片")
		private String prizeImg;
		@ApiModelProperty(value = "奖品积分")
		private BigDecimal score;
	}
	
}
