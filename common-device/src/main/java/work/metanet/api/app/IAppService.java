package work.metanet.api.app;

import java.util.List;

import work.metanet.api.app.protocol.ReqAppInfo;
import work.metanet.api.app.protocol.ReqAppInfo.RespAppInfo;
import work.metanet.api.app.protocol.ReqAppList;
import work.metanet.api.app.protocol.ReqAppList.RespAppList;
import work.metanet.api.app.protocol.ReqEnableSn;
import work.metanet.api.app.protocol.ReqRemoveApp;
import work.metanet.api.app.protocol.ReqSaveApp;
import work.metanet.api.app.vo.AppKeyVo;
import work.metanet.api.app.vo.AppVo;
import work.metanet.api.upgradePlan.protocol.ReqUpgrade;
import work.metanet.api.upgradePlan.protocol.ReqUpgrade.RespUpgrade;
import work.metanet.base.RespPaging;

public interface IAppService {
	
	/**
	 * @Description: 清除产品升级缓存
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/22
	 */
	void clearAppUpgradeCache(String packageName) throws Exception;
	
	AppVo getAppByPackageName(String packageName) throws Exception;
	
	AppVo getAppByAppId(String appId) throws Exception;

	/**
	 * @Description: 产品列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespPaging<RespAppList> appList(ReqAppList req) throws Exception;
	
	/**
	 * @Description: 产品详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespAppInfo appInfo(ReqAppInfo req) throws Exception;
	
	/**
	 * @Description: 保存产品
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void saveApp(ReqSaveApp req) throws Exception;
	
	/**
	 * @Description: 删除产品
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removeApp(List<ReqRemoveApp> req) throws Exception;
	
	/**
	 * @Description: 启用激活码激活
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/09
	 */
	void enableSn(ReqEnableSn req) throws Exception;
	
	
	/**
	 * @Description: 产品升级
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/12/04
	 */
	RespUpgrade upgrade(ReqUpgrade requestParam,String versionCode,String packageName) throws Exception;
	
	/**
	 * @Description: 产品升级v2
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/12/04
	 */
	RespUpgrade upgrade_v2(ReqUpgrade requestParam,String versionCode,String packageName) throws Exception;
	
	AppKeyVo appKey(String appId) throws Exception;
	
	List<AppVo> appVoList(String channelId) throws Exception;
	
	
}
