package work.metanet.api.userScoreDetail.protocol;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel("请求-用户积分明细列表")
@EqualsAndHashCode(callSuper=true)
@Data
public class ReqAppUserScoreDetail extends Paging implements Serializable{
	
	private static final long serialVersionUID = -7143347865118258236L;
	
	@ApiModelProperty(value = "查询日期-格式:202007")
	private String date;
	
	@ApiModelProperty(value = "触发类型-EDU:学习积分|EXCHANGE:积分兑换")
	private String changeType;
	
	@JsonIgnore
	private String userId;
	
	@Data
	public static class RespAppUserScoreDetail implements Serializable {
		private static final long serialVersionUID = 7574502061391300720L;
		@ApiModelProperty(value = "触发时间")
		private String createTime;
		@ApiModelProperty(value = "触发积分值")
		private BigDecimal changeValue;
		@ApiModelProperty(value = "触发后的积分")
		private BigDecimal afterValue;
		@ApiModelProperty(value = "备注")
		private String remark;
	}

}
