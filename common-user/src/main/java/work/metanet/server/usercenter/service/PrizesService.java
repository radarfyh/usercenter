package work.metanet.server.usercenter.service;

import work.metanet.api.prize.protocol.ReqPrizeStore;
import work.metanet.base.RespPaging;
import work.metanet.base.service.CurdService;
import work.metanet.server.usercenter.domain.UcPrizes;

public interface PrizesService extends CurdService<UcPrizes> {
	
	/**
	 * @Description: 获取商品
	 */
	RespPaging<UcPrizes> getPrizesList(ReqPrizeStore req) throws Exception;
	
	/**
	 * @Description: 获取商品对象-加入排他锁
	 */
	UcPrizes getPrizeByIdLock(String prizeId);
	
	/**
	 * @Description: 更新库存
	 */
	int updateInventory(String prizeId, Integer number);
}
