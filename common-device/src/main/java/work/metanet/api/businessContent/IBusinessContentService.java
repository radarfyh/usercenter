package work.metanet.api.businessContent;

import java.util.List;

import work.metanet.api.businessContent.protocol.ReqBusinessContentInfo;
import work.metanet.api.businessContent.protocol.ReqBusinessContentInfo.RespBusinessContentInfo;
import work.metanet.api.businessContent.protocol.ReqBusinessContentList;
import work.metanet.api.businessContent.protocol.ReqBusinessContentList.RespBusinessContentList;
import work.metanet.api.businessContent.protocol.ReqRemoveBusinessContent;
import work.metanet.api.businessContent.protocol.ReqSaveBusinessContent;
import work.metanet.api.businessContent.protocol.ReqSaveBusinessContent.RespSaveBusinessContent;
import work.metanet.api.businessContent.protocol.ReqUpdBusinessContentParent;

public interface IBusinessContentService {
	
	/**
	 * @Description: 内容商内容列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	List<RespBusinessContentList> businessContentList(ReqBusinessContentList req) throws Exception;
	
	/**
	 * @Description: 内容商内容详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespBusinessContentInfo businessContentInfo(ReqBusinessContentInfo req) throws Exception;
	
	/**
	 * @Description: 保存内容商内容
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespSaveBusinessContent saveBusinessContent(ReqSaveBusinessContent req) throws Exception;
	
	/**
	 * @Description: 删除内容商内容
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removeBusinessContent(List<ReqRemoveBusinessContent> req) throws Exception;
	
	/**
	 * @Description: 修改父级节点
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void updBusinessContentParent(List<ReqUpdBusinessContentParent> req) throws Exception;
}
