package work.metanet.api.fmreward;

import work.metanet.api.fmreward.protocol.ReqAddReward;

public interface IFmRewardService {

	/**
	 * @Description: 新增奖励
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/16
	 */
	void addReward(ReqAddReward req)throws Exception;
	
}
