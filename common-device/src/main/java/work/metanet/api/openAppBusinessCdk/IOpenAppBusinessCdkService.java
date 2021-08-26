package work.metanet.api.openAppBusinessCdk;

import java.util.List;

import work.metanet.api.openAppBusinessCdk.protocol.ReqOpenAppBusinessCdkImport;
import work.metanet.api.openAppBusinessCdk.protocol.ReqOpenAppBusinessCdkList;
import work.metanet.api.openAppBusinessCdk.protocol.ReqOpenAppBusinessCdkList.RespOpenAppBusinessCdkList;
import work.metanet.api.openAppBusinessCdk.protocol.ReqOpenAppBusinessCdkRemove;
import work.metanet.base.RespPaging;
import work.metanet.model.OpenAppBusinessCdk;

public interface IOpenAppBusinessCdkService {
	
	OpenAppBusinessCdk info(String openAppBusinessCdkId) throws Exception;
	
	/**
	 * @Description: 获取应用业务cdk
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/10/12
	 */
	String getOpenAppBusinessCdk(String openDeviceId, String appId, String businessCode) throws Exception;
	
	RespPaging<RespOpenAppBusinessCdkList> appBusinessCdkList(ReqOpenAppBusinessCdkList req) throws Exception;
	
	void saveAppBusinessCdk(OpenAppBusinessCdk openAppBusinessCdk) throws Exception;
	
	void removeAppBusinessCdk(List<ReqOpenAppBusinessCdkRemove> req) throws Exception;
	
	void importAppBusinessCdk(ReqOpenAppBusinessCdkImport cdk) throws Exception;
}
