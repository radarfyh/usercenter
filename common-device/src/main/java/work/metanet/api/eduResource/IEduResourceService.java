package work.metanet.api.eduResource;

import work.metanet.api.eduResource.protocol.ReqEduResourceDetail;
import work.metanet.api.eduResource.protocol.ReqEduResourceDetail.RespEduResourceDetail;
import work.metanet.api.eduResource.protocol.ReqEduResourceInfo;
import work.metanet.api.eduResource.protocol.ReqRecommendResource;
import work.metanet.api.eduResource.protocol.ReqSearchResource;
import work.metanet.api.eduResource.vo.EduResourceVo;
import work.metanet.base.RespPaging;

public interface IEduResourceService {
	
	/**
	 * @Description: 资源信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/16
	 */
	EduResourceVo eduResourceInfo(ReqEduResourceInfo req)throws Exception;
	
	/**
	 * @Description: 搜索资源
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/05
	 */
	RespPaging<EduResourceVo> searchResource(ReqSearchResource req)throws Exception;
	
	/**
	 * @Description: 推荐资源
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/05
	 */
	RespPaging<EduResourceVo> recommendResource(ReqRecommendResource req)throws Exception;
	
	/**
	 * @Description: 资源详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/31
	 */
	RespPaging<RespEduResourceDetail> getEduResourceDetail(ReqEduResourceDetail req) throws Exception;
	
}
