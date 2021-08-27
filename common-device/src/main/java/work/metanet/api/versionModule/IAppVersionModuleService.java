package work.metanet.api.versionModule;

import java.util.List;

import work.metanet.api.versionModule.protocol.ReqAppVersionModuleInfo;
import work.metanet.api.versionModule.protocol.ReqAppVersionModuleInfo.RespAppVersionModuleInfo;
import work.metanet.api.versionModule.protocol.ReqAppVersionModuleList;
import work.metanet.api.versionModule.protocol.ReqAppVersionModuleList.RespAppVersionModuleList;
import work.metanet.api.versionModule.protocol.ReqRemoveAppVersionModule;
import work.metanet.api.versionModule.protocol.ReqSaveAppVersionModule;
import work.metanet.api.versionModule.protocol.ReqUpdAppVersionModuleParent;
import work.metanet.api.versionModule.protocol.ReqViewAppVersionModule.RespViewAppVersionModule;

public interface IAppVersionModuleService {
	
	/**
	 * @Description: 展示产品模块
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespViewAppVersionModule viewAppVersionModule(String packageName,String versionCode)throws Exception;
	
	/**
	 * @Description: 版本模块列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	List<RespAppVersionModuleList> appVersionModuleList(ReqAppVersionModuleList req) throws Exception;
	
	/**
	 * @Description: 版本模块详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespAppVersionModuleInfo appVersionModuleInfo(ReqAppVersionModuleInfo req) throws Exception;
	
	/**
	 * @Description: 保存版本模块
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void saveAppVersionModule(ReqSaveAppVersionModule req) throws Exception;
	
	/**
	 * @Description: 删除版本模块
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removeAppVersionModule(List<ReqRemoveAppVersionModule> req) throws Exception;
	
	/**
	 * @Description: 修改父级节点
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void updAppVersionModuleParent(List<ReqUpdAppVersionModuleParent> req) throws Exception;
}
