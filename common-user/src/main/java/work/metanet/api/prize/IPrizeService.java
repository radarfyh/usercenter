package work.metanet.api.prize;

import work.metanet.api.prize.protocol.ReqPrizeStore;
import work.metanet.api.prize.protocol.ReqPrizeStore.RespPrizeStore;
import work.metanet.api.prize.vo.PrizeVo;
import work.metanet.base.RespPaging;

public interface IPrizeService {
	
	/**
	 * @Description: 商城
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/28
	 */
	RespPaging<RespPrizeStore> prizeStore(ReqPrizeStore req) throws Exception;
	
	/**
	 * @Description: 获取商品对象-加入排他锁
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/30
	 */
	PrizeVo getPrizeVoByIdLock(String prizeId);
	
	/**
	 * @Description: 更新库存
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/30
	 */
	int updatePrizeInventory(String prizeId, Integer number);
	
}
