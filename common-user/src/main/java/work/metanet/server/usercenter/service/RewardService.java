package work.metanet.server.usercenter.service;

import work.metanet.server.usercenter.domain.UcRewards;
import work.metanet.base.service.CurdService;

public interface RewardService extends CurdService<UcRewards> {

	/**
	 * @Description: 新增奖励
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/16
	 */
	void addReward(UcRewards req) throws Exception;
	
}
