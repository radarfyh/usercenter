package work.metanet.api.eduTimetable.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import work.metanet.api.eduResource.vo.EduResourceVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("响应-课程表")
@Data
public class EduTimetableVo implements Serializable{
	private static final long serialVersionUID = 5138043580575693734L;
	@ApiModelProperty(value = "课程表id")
	private String timetableId;
	@ApiModelProperty(value = "年龄")
	private Integer age;
	@ApiModelProperty(value = "一周开始日期")
	private String startDate;
	@ApiModelProperty(value = "一周截止日期")
	private String endDate;
	@ApiModelProperty(value = "课程表内容")
	private String content;
	@ApiModelProperty(value = "课程表资源")
	private List<EduResourceVo> resourceList = new ArrayList<EduResourceVo>();
	
}