package work.metanet.api.eduTimetable.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-课程表资源")
@Accessors(chain = true)
@Data
public class ReqEduTimetableResource implements Serializable{
	
	private static final long serialVersionUID = 1270880749267479961L;
	@ApiModelProperty(value = "课程表id",required = true)
	@NotBlank(message = "课程表id不能为空")
	private String timetableId;
	@JsonIgnore
	private String userId;
}
