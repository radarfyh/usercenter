package work.metanet.api.userScoreDetail;

import work.metanet.api.userScoreDetail.protocol.ReqAppUserScoreDetail;
import work.metanet.api.userScoreDetail.protocol.ReqAppUserScoreDetail.RespAppUserScoreDetail;
import work.metanet.api.userScoreDetail.protocol.ReqUserScoreDetailList;
import work.metanet.api.userScoreDetail.protocol.ReqUserScoreDetailList.RespUserScoreDetailList;
import work.metanet.base.RespPaging;

public interface IUserScoreDetailService {

	/**
	 * @Description: 积分明细
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/02
	 */
	RespPaging<RespAppUserScoreDetail> appUserScoreDetail(ReqAppUserScoreDetail req) throws Exception;
	
	/**
	 * @Description: 用户积分明细列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/08
	 */
	RespPaging<RespUserScoreDetailList> userScoreDetailList(ReqUserScoreDetailList req) throws Exception;
	
}
