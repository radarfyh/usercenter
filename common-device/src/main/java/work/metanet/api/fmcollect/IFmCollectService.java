package work.metanet.api.fmcollect;

import work.metanet.api.fmcollect.protocol.ReqAddFmCollect;
import work.metanet.api.fmcollect.protocol.ReqFmCollectList;
import work.metanet.api.fmcollect.protocol.ReqFmCollectList.RespFmCollectList;
import work.metanet.base.RespPaging;

public interface IFmCollectService {

	/**
	 * @Description: 新增收藏
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/27
	 */
	void addFmCollect(String userId,ReqAddFmCollect req) throws Exception;
	
	/**
	 * @Description: 资源收藏列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/27
	 */
	RespPaging<RespFmCollectList> fmCollectList(String userId, ReqFmCollectList req) throws Exception;
	
}
