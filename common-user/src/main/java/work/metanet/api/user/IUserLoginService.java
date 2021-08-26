package work.metanet.api.user;

public interface IUserLoginService {
	
	/**
	 * @Description:登录记录 
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/28
	 */
	void loginRecord(String userId,String deviceId,String versionId);
	
}