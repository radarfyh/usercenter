package work.metanet.server.usercenter.service;

import work.metanet.server.usercenter.domain.UcUserLogins;
import work.metanet.base.service.CurdService;

public interface LoginService extends CurdService<UcUserLogins> {
	void loginRecord(String userId,String deviceId,String versionId);
}
