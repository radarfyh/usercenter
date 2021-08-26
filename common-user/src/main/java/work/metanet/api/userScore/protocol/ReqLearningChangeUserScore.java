package work.metanet.api.userScore.protocol;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-学习触发用户积分")
@Accessors(chain = true)
@Data
public class ReqLearningChangeUserScore implements Serializable{
	
	private static final long serialVersionUID = -7936091524473208182L;
	@ApiModelProperty(value = "学习时长(分钟)", required = true)
	@NotNull
	private Long learningMinutes;
	
	/**
	 * 请求时间
	 */
	@JsonIgnore
	private String callTime;
	
	/**
	 * 日累计总积分
	 */
	@JsonIgnore
	private BigDecimal daySumScore;
	
}
