package work.metanet.api.channelEarningsDetail;

import work.metanet.api.channelEarningsDetail.protocol.ReqChannelEarningsDetailList;
import work.metanet.api.channelEarningsDetail.protocol.ReqChannelEarningsDetailList.RespChannelEarningsDetailList;
import work.metanet.base.RespPaging;

public interface IChannelEarningsDetailService {

	RespPaging<RespChannelEarningsDetailList> channelEarningsDetailList(ReqChannelEarningsDetailList req) throws Exception;
	
}
