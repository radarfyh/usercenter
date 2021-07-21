package work.metanet.api.thirdBusiness;

import work.metanet.api.thirdBusiness.protocol.ReqThirdBusinessList;
import work.metanet.api.thirdBusiness.protocol.ReqThirdBusinessList.RespThirdBusinessList;
import work.metanet.base.RespPaging;

public interface IThirdBusinessService {
	
	RespPaging<RespThirdBusinessList> thirdBusinessList(ReqThirdBusinessList req) throws Exception;
	
}
