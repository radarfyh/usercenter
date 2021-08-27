package work.metanet.server.device.service;

import work.metanet.server.device.domain.UcCollections;
import work.metanet.api.fmcollect.protocol.ReqAddFmCollect;
import work.metanet.api.fmcollect.protocol.ReqFmCollectList;
import work.metanet.api.fmcollect.protocol.ReqFmCollectList.RespFmCollectList;
import work.metanet.base.RespPaging;
import work.metanet.base.service.CurdService;

public interface CollectService extends CurdService<UcCollections> {

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
