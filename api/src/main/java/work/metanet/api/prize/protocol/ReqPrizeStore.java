package work.metanet.api.prize.protocol;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@ApiModel("请求-奖品商城")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=true)
@Data
public class ReqPrizeStore extends Paging implements Serializable{
	
	private static final long serialVersionUID = 5448598344020657643L;
	@JsonIgnore
	private String packageName;
	
	@ApiModel("响应-奖品商城")
	@Data
	public static class RespPrizeStore implements Serializable{
		private static final long serialVersionUID = -4963307395308034601L;
		@ApiModelProperty(value = "奖品id")
		private String prizeId;
		@ApiModelProperty(value = "奖品名称")
		private String prizeName;
		@ApiModelProperty(value = "奖品图片")
		private String prizeImg;
		@ApiModelProperty(value = "积分")
		private Integer score;
		
		
	}

}
