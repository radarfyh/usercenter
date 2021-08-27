package work.metanet.api.userTargetPrize;

import java.math.BigDecimal;

import work.metanet.api.userTargetPrize.protocol.ReqSaveUserTargetPrize;
import work.metanet.api.userTargetPrize.protocol.ReqUserTargetPrizeInfo.RespUserTargetPrizeInfo;

public interface IUserTargetPrizeService {

	/**
	 * @Description: 用户订购信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/29
	 */
	RespUserTargetPrizeInfo userTargetPrizeInfo(String userId) throws Exception;
	
	/**
	 * @Description: 保存用户订购信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/29
	 */
	void saveUserTargetProze(String userId, ReqSaveUserTargetPrize req) throws Exception;
	
	
	/**
	 * @Description: 用户订购完成率
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/08/31
	 */
	BigDecimal prizeCompletion(String userId) throws Exception;
	
}
