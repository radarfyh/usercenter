package work.metanet.api.family.protocol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-成长记录")
@Accessors(chain = true)
@Data
public class ReqGrowthRecord implements Serializable{
	
	private static final long serialVersionUID = 5448598344020657643L;
	@ApiModelProperty(value = "月份日期-格式:202001", required = true)
	@NotBlank(message = "月份日期")
	private String month;
	@JsonIgnore
	private String userId;
	
	
	@ApiModel("响应-成长记录")
	@Data
	public static class RespGrowthRecord implements Serializable{
		private static final long serialVersionUID = -4963307395308034601L;
		@ApiModelProperty(value = "成长记录信息")
		private String info;
		@ApiModelProperty("疫苗信息")
		private List<RespGrowthRecordVaccine> vaccineList = new ArrayList<RespGrowthRecordVaccine>();
	}
	
	@ApiModel("响应-成长记录疫苗信息")
	@Data
	public static class RespGrowthRecordVaccine implements Serializable{
		private static final long serialVersionUID = -4963307395308034601L;
		@ApiModelProperty(value = "疫苗日期")
		private String vaccineDate;
		@ApiModelProperty("疫苗信息")
		private String vaccineInfo;
	}

}
