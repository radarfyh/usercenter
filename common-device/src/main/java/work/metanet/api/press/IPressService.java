package work.metanet.api.press;

import java.util.List;

import work.metanet.api.press.protocol.ReqPressList.RespPressList;

public interface IPressService {
	
	List<RespPressList> pressList() throws Exception;
	
}
