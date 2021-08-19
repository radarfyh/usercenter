package work.metanet.server.usercenter.service;

import java.math.BigDecimal;

import work.metanet.server.usercenter.domain.UcTargetPrizes;
import work.metanet.api.userTargetPrize.protocol.ReqSaveUserTargetPrize;
import work.metanet.api.userTargetPrize.protocol.ReqUserTargetPrizeInfo.RespUserTargetPrizeInfo;
import work.metanet.base.service.CurdService;

public interface OrderService extends CurdService<UcTargetPrizes> {

	/**
	 * @Description: 用户订购信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/29
	 */
	RespUserTargetPrizeInfo userTargetPrizeInfo(String userId) throws Exception;
	
	/**
	 * @Description: 保存用户订购信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/29
	 */
	void saveUserTargetProze(String userId, ReqSaveUserTargetPrize req) throws Exception;
	
	
	/**
	 * @Description: 用户订购完成率
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/08/31
	 */
	BigDecimal prizeCompletion(String userId) throws Exception;
	
}
