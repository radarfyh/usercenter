package work.metanet.api.deviceApp;

public interface IDeviceAppService {
	
	/**
	 * @Description: 设备产品是否激活
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/28
	 */
	boolean isActivate(String deviceAppId) throws Exception;
	
	String getDeviceAppId(String deviceId,String packageName) throws Exception;
	
}
