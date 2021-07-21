package work.metanet.server.usercenter.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;

import work.metanet.server.usercenter.repository.UserLoginRepository;
import work.metanet.server.usercenter.service.LoginService;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.server.usercenter.domain.UcUserLogins;

@DubboService
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Async
	@Override
	public void loginRecord(String userId, String deviceId, String versionId) {
		UcUserLogins userLogin = new UcUserLogins()
				.setUserId(userId)
				.setDeviceId(deviceId)
				.setVersionId(versionId);
		userLoginRepository.save(userLogin);
	}

	@Override
	public int save(UcUserLogins record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcUserLogins record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcUserLogins record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcUserLogins record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcUserLogins record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcUserLogins> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcUserLogins findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcUserLogins> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcUserLogins> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
