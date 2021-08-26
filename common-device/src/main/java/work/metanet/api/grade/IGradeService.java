package work.metanet.api.grade;

import java.util.List;

import work.metanet.api.grade.protocol.ReqGradeList.RespGradeList;

public interface IGradeService {
	
	List<RespGradeList> gradeList() throws Exception;
	
}
