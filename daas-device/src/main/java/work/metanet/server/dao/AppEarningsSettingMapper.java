/**  
 * @Title: OrderMapper.java
 * @Description: TODO
 * @Author Louis & Edison & W.B.
 * @date 2018年3月28日
 */
package work.metanet.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import work.metanet.api.app.vo.AppEarningsSettingVo;
import work.metanet.model.AppEarningsSetting;

import tk.mybatis.mapper.common.Mapper;

public interface AppEarningsSettingMapper extends Mapper<AppEarningsSetting>{
	
	@Select("select app_id,third_business_id,settlement_ratio from t_app_earnings_setting where status=true and app_id=#{appId}")
	List<AppEarningsSettingVo> appEarningsSettings(@Param("appId")String appId);
	
	@Select("select * from t_app_earnings_setting where status=true and app_id=#{appId}")
	List<AppEarningsSetting> appEarningsSettingList(@Param("appId")String appId);
	
	@Select("select * from 	t_app_earnings_setting where status=true and app_id=#{appId} and third_business_id=#{thirdBusinessId}")
	AppEarningsSetting getAppEarningsSetting(@Param("appId")String appId,@Param("thirdBusinessId")String thirdBusinessId);
}
