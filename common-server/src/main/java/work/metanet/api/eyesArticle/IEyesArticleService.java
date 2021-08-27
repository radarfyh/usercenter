package work.metanet.api.eyesArticle;

import work.metanet.api.eyesArticle.protocol.*;
import work.metanet.base.RespPaging;

import java.util.List;

public interface IEyesArticleService {
	
	/**
	 * @Description: 爱眼软文列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/24
	 */
	RespPaging<ReqAppEyesArticleList.RespAppEyesArticleList> appEyesArticleList(ReqAppEyesArticleList req) throws Exception;
	
	int removeEyesArticle(List<ReqRemoveEyesArticle> req) throws Exception;
	
	RespPaging<ReqEyesArticleList.RespEyesArticleList> eyesArticleList(ReqEyesArticleList req) throws Exception;
	
	ReqEyesArticleInfo.RespEyesArticleInfo EyesArticleInfo(ReqEyesArticleInfo req) throws Exception;
	
	void updateEyesArticle(ReqUpdateEyesArticle req) throws Exception;

	void insertEyesArticle(ReqInsertEyesArticle req)throws Exception;


}
