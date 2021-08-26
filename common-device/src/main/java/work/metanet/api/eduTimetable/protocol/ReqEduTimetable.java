package work.metanet.api.eduTimetable.protocol;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-课程表")
@Accessors(chain = true)
@Data
public class ReqEduTimetable implements Serializable{
	
	private static final long serialVersionUID = 1270880749267479961L;
	@JsonIgnore
	private String userId;
}
