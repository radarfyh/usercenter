package work.metanet.api.userScoreExchange;

import work.metanet.api.userScoreExchange.protocol.ReqSaveUserScoreExchange;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchange;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchangeInfo.RespUserScoreExchangeInfo;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchangeList;
import work.metanet.api.userScoreExchange.protocol.ReqUserScoreExchangeList.RespUserScoreExchangeList;
import work.metanet.base.RespPaging;

public interface IUserScoreExchangeService {

	/**
	 * @Description: 用户积分兑换
	 * @Author edison F. & w.b.
	 * @DateTime 2021/07/29
	 */
	void userScoreExchange(String userId, ReqUserScoreExchange req) throws Exception;
	
	/**
	 * @Description: 积分兑换信息
	 * @Author edison F. & w.b.
	 * @DateTime 2021/07/01
	 */
	RespUserScoreExchangeInfo userScoreExchangeInfo(String userScoreExchangeId) throws Exception;
	
	/**
	 * @Description: 兑换列表
	 * @Author edison F. & w.b.
	 * @DateTime 2021/08/31
	 */
	RespPaging<RespUserScoreExchangeList> userScoreExchangeList(ReqUserScoreExchangeList req) throws Exception;
	
	void saveUserScoreExchange(ReqSaveUserScoreExchange req) throws Exception;
}
