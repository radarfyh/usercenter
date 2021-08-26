package work.metanet.api.businessApp;

import java.util.List;
import java.util.Map;

import work.metanet.api.businessApp.protocol.ReqBusinessAppInfo;
import work.metanet.api.businessApp.protocol.ReqBusinessAppInfo.RespBusinessAppInfo;
import work.metanet.api.businessApp.protocol.ReqBusinessAppList;
import work.metanet.api.businessApp.protocol.ReqBusinessAppList.RespBusinessAppList;
import work.metanet.api.businessApp.protocol.ReqUpgradeThirdApp;
import work.metanet.api.businessApp.protocol.ReqRemoveBusinessApp;
import work.metanet.api.businessApp.protocol.ReqSaveBusinessApp;
import work.metanet.api.businessApp.vo.BusinessAppVo;
import work.metanet.base.RespPaging;

public interface IBusinessAppService {
	
	/**
	 * @Description: 第三方产品升级
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/27
	 */
	BusinessAppVo upgradeThirdApp(ReqUpgradeThirdApp req) throws Exception;
	
	/**
	 * @Description: 内容商应用树
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/06
	 */
	List<Map<String, Object>> businessAppTree() throws Exception;

	/**
	 * @Description: 内容商产品列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	RespPaging<RespBusinessAppList> businessAppList(ReqBusinessAppList req) throws Exception;
	
	/**
	 * @Description: 内容商产品详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	RespBusinessAppInfo businessAppInfo(ReqBusinessAppInfo req) throws Exception;
	
	/**
	 * @Description: 保存内容商产品
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	void saveBusinessApp(ReqSaveBusinessApp req) throws Exception;
	
	/**
	 * @Description: 删除内容商产品
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	void removeBusinessApp(List<ReqRemoveBusinessApp> req) throws Exception;
	
	
}
