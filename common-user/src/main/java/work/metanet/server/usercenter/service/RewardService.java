package work.metanet.server.usercenter.service;

import work.metanet.server.usercenter.domain.UcRewards;
import work.metanet.api.fmreward.protocol.ReqAddReward;
import work.metanet.base.service.CurdService;

public interface RewardService extends CurdService<UcRewards> {

	/**
	 * @Description: 新增奖励
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/16
	 */
	void addReward(ReqAddReward req) throws Exception;
	
}
