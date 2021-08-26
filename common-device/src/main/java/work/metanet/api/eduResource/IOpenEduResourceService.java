package work.metanet.api.eduResource;

import java.util.List;

import work.metanet.api.eduResource.protocol.ReqOpenEduResourceDetail;
import work.metanet.api.eduResource.protocol.ReqOpenEduResourceInfo;
import work.metanet.api.eduResource.protocol.ReqOpenRecommendResource;
import work.metanet.api.eduResource.protocol.ReqOpenSearchResource;
import work.metanet.api.eduResource.vo.OpenEduResourceBaseVo;
import work.metanet.api.eduResource.vo.OpenEduResourceInfoVo;
import work.metanet.base.RespPaging;

public interface IOpenEduResourceService {
	
	/**
	 * @Description: 搜索资源
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/09/24
	 */
	RespPaging<OpenEduResourceBaseVo> searchResource(ReqOpenSearchResource req) throws Exception;
	
	/**
	 * @Description: 推荐资源
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/09/24
	 */
	List<OpenEduResourceBaseVo> recommendResource(ReqOpenRecommendResource req) throws Exception;

	/**
	 * @Description: 资源详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/09/24
	 */
	OpenEduResourceInfoVo eduResourceInfo(ReqOpenEduResourceInfo req) throws Exception;
	
	/**
	 * @Description: 资源明细列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/31
	 */
	RespPaging<OpenEduResourceInfoVo> eduResourceDetail(ReqOpenEduResourceDetail req) throws Exception;
}
