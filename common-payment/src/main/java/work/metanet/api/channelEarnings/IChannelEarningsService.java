package work.metanet.api.channelEarnings;

import work.metanet.api.channelEarnings.protocol.ReqChannelEarningsList;
import work.metanet.api.channelEarnings.protocol.ReqChannelEarningsList.RespChannelEarningsList;
import work.metanet.api.channelEarnings.protocol.ReqImportChannelEarnings;
import work.metanet.base.RespPaging;

public interface IChannelEarningsService {

	/**
	 * @Description: 渠道收益列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/05
	 */
	RespPaging<RespChannelEarningsList> channelEarningsList(ReqChannelEarningsList req) throws Exception;
	
	/**
	 * @Description: 渠道收益导入
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/05
	 */
	void importChannelEarnings(ReqImportChannelEarnings req
			, String thirdBusinessId, String channelId, Double settlementRatio) throws Exception;
}
