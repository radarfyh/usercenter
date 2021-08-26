package work.metanet.server.usercenter.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import work.metanet.server.usercenter.repository.UserAddressRepository;
import work.metanet.server.usercenter.service.AddressService;
import work.metanet.api.userAddress.protocol.ReqSaveUserAddress;
import work.metanet.api.userAddress.protocol.ReqSaveUserAddress.RespSaveUserAddress;
import work.metanet.api.userAddress.protocol.ReqUserAddressInfo.RespUserAddressInfo;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.server.usercenter.domain.UcUserAddresses;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;

@DubboService
@RefreshScope
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private UserAddressRepository userAddressRepository;
	
	@Override
	public RespSaveUserAddress saveUserAddress(String userId, ReqSaveUserAddress req) throws Exception {
		UcUserAddresses userAddress = BeanUtil.copyProperties(req, UcUserAddresses.class);
		if(StrUtil.isBlank(req.getUserAddressId())) {
			userAddress.setUserId(userId);
			userAddressRepository.save(userAddress);
		}else {
			userAddressRepository.save(userAddress);
		}
		return BeanUtil.copyProperties(userAddress, RespSaveUserAddress.class);
	}
	
	@Override
	public RespUserAddressInfo userAddressInfo(String userId) throws Exception {
		return BeanUtil.copyProperties(userAddressRepository.userAddressInfo(userId), RespUserAddressInfo.class);
	}

	@Override
	public int save(UcUserAddresses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcUserAddresses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcUserAddresses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcUserAddresses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcUserAddresses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcUserAddresses> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcUserAddresses findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcUserAddresses> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcUserAddresses> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
