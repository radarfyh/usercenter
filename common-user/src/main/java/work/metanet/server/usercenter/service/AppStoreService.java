package work.metanet.server.usercenter.service;

import java.util.List;

import work.metanet.api.storeApp.protocol.ReqSaveStoreApp;
import work.metanet.api.storeApp.protocol.ReqSearchStoreApp;
import work.metanet.api.storeApp.protocol.ReqStoreAppInfo;
import work.metanet.api.storeApp.protocol.ReqStoreAppList;
import work.metanet.base.RespPaging;
import work.metanet.base.service.CurdService;
import work.metanet.server.usercenter.domain.UcAppStore;

public interface AppStoreService extends CurdService<UcAppStore> {
	
	/**
	 * @Description: 应用商店搜索
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/05/26
	 */
	RespPaging<UcAppStore> searchStoreApp(ReqSearchStoreApp req) throws Exception;

	/**
	 * @Description: 应用商店列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	RespPaging<UcAppStore> storeAppList(ReqStoreAppList req) throws Exception;
	
	/**
	 * @Description: 应用商店详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	UcAppStore storeAppInfo(ReqStoreAppInfo req) throws Exception;
	
	/**
	 * @Description: 保存应用商店
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	void saveStoreApp(ReqSaveStoreApp req) throws Exception;
	
	/**
	 * @Description: 删除应用商店
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	void removeStoreApp(List<UcAppStore> req) throws Exception;
}
