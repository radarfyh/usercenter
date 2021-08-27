package work.metanet.api.fmbrowse;

import work.metanet.api.fmbrowse.protocol.ReqAddFmBrowse;
import work.metanet.api.fmbrowse.protocol.ReqFmBrowseList;
import work.metanet.api.fmbrowse.protocol.ReqFmBrowseList.RespFmBrowseList;
import work.metanet.base.RespPaging;

public interface IFmBrowseService {

	/**
	 * @Description: 新增浏览记录
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/27
	 */
	void addFmBrowse(String userId,ReqAddFmBrowse req) throws Exception;
	
	/**
	 * @Description: 资源浏览记录列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/27
	 */
	RespPaging<RespFmBrowseList> fmBrowseList(String userId, ReqFmBrowseList req) throws Exception;
	
}
