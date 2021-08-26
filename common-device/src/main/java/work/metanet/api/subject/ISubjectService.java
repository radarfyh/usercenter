package work.metanet.api.subject;

import work.metanet.api.subject.protocol.ReqSubjectList.RespSubjectList;

import java.util.List;

public interface ISubjectService {

	List<RespSubjectList> subjectList() throws Exception;
	
}
