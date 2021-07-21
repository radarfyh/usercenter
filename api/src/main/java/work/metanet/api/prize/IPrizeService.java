package work.metanet.api.prize;

import work.metanet.api.prize.protocol.ReqPrizeStore;
import work.metanet.api.prize.protocol.ReqPrizeStore.RespPrizeStore;
import work.metanet.api.prize.vo.PrizeVo;
import work.metanet.base.RespPaging;

public interface IPrizeService {
	
	/**
	 * @Description: 奖品商城
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/28
	 */
	RespPaging<RespPrizeStore> prizeStore(ReqPrizeStore req) throws Exception;
	
	/**
	 * @Description: 获取奖品对象-加入排他锁
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/30
	 */
	PrizeVo getPrizeVoByIdLock(String prizeId);
	
	/**
	 * @Description: 更新库存
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/30
	 */
	int updatePrizeInventory(String prizeId, Integer number);
	
}
