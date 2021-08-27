package work.metanet.server.device.service;

import work.metanet.server.device.domain.UcBrowses;
import work.metanet.api.fmbrowse.protocol.ReqAddFmBrowse;
import work.metanet.api.fmbrowse.protocol.ReqFmBrowseList;
import work.metanet.api.fmbrowse.protocol.ReqFmBrowseList.RespFmBrowseList;
import work.metanet.base.RespPaging;
import work.metanet.base.service.CurdService;

public interface BrowseService extends CurdService<UcBrowses> {

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
