package work.metanet.api.upgradePlan;

import java.util.List;

import work.metanet.api.upgradePlan.protocol.ReqRemoveUpgradePlan;
import work.metanet.api.upgradePlan.protocol.ReqSaveUpgradePlan;
import work.metanet.api.upgradePlan.protocol.ReqSendUpgradePlan;
import work.metanet.api.upgradePlan.protocol.ReqUpgradePlanInfo;
import work.metanet.api.upgradePlan.protocol.ReqUpgradePlanInfo.RespUpgradePlanInfo;
import work.metanet.api.upgradePlan.protocol.ReqUpgradePlanList;
import work.metanet.api.upgradePlan.protocol.ReqUpgradePlanList.RespUpgradePlanList;
import work.metanet.base.RespPaging;

public interface IUpgradePlanService {

	/**
	 * @Description: 升级计划列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespPaging<RespUpgradePlanList> upgradePlanList(ReqUpgradePlanList req) throws Exception;
	
	/**
	 * @Description: 升级计划详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespUpgradePlanInfo upgradePlanInfo(ReqUpgradePlanInfo req) throws Exception;
	
	/**
	 * @Description: 保存升级计划
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void saveUpgradePlan(ReqSaveUpgradePlan req) throws Exception;
	
	/**
	 * @Description: 删除升级计划
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removeUpgradePlan(List<ReqRemoveUpgradePlan> req) throws Exception;
	
	/**
	 * @Description: 发布升级计划
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/29
	 */
	void sendUpgradePlan(ReqSendUpgradePlan req) throws Exception;
	
	
	
	
}
