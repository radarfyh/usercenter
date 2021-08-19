/**  
 * @Title: OrderMapper.java
 * @Description: TODO
 * @author wanbo
 * @date 2018年3月28日
 */
package work.metanet.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import work.metanet.api.prize.protocol.ReqPrizeStore;
import work.metanet.api.prize.protocol.ReqPrizeStore.RespPrizeStore;
import work.metanet.model.Prize;

import tk.mybatis.mapper.common.Mapper;

public interface PrizeMapper extends Mapper<Prize>{
	
	/**
	 * @Description: 奖品商城
	 * @Author wanbo
	 * @DateTime 2020/06/28
	 */
	List<RespPrizeStore> prizeStore(ReqPrizeStore req);
	
	/**
	 * @Description: 获取奖品对象-加入拍他锁
	 * @Author wanbo
	 * @DateTime 2020/06/30
	 */
	@Select("select * from t_prize where prize_id=#{prizeId} for update")
	Prize getPrizeVoByIdLock(String prizeId);
	
	/**
	 * @Description: 更新库存
	 * @Author wanbo
	 * @DateTime 2020/06/30
	 */
	@Update("update t_prize set inventory=inventory+${number} where prize_id=#{prizeId}")
	int updatePrizeInventory(@Param("prizeId")String prizeId,@Param("number")Integer number);
	
}
