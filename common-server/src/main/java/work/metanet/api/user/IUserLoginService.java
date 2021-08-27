package work.metanet.api.user;

public interface IUserLoginService {
	
	/**
	 * @Description:登录记录 
	 * @Author edison F. & w.b.
	 * @DateTime 2021/07/28
	 */
	void loginRecord(String userId,String deviceId,String versionId);
	
}
