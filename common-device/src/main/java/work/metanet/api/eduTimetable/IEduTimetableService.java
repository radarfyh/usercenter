package work.metanet.api.eduTimetable;

import java.util.List;

import work.metanet.api.eduResource.vo.EduResourceVo;
import work.metanet.api.eduTimetable.protocol.ReqEduTimetable;
import work.metanet.api.eduTimetable.protocol.ReqEduTimetableResource;
import work.metanet.api.eduTimetable.vo.EduTimetableVo;

public interface IEduTimetableService {
	
	/**
	 * @Description: 指定资源是否存在与本周资源
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/16
	 */
	boolean existsThisWeekResource(String userId,String resourceId)throws Exception;
	
	/**
	 * @Description: 课程表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/13
	 */
	List<EduTimetableVo> timetableList(ReqEduTimetable req) throws Exception;

	/**
	 * @Description: 课程表资源
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/13
	 */
	List<EduResourceVo> timetableResource(ReqEduTimetableResource req) throws Exception;
	
}
