package work.metanet.server.usercenter.service;

import work.metanet.server.usercenter.domain.UcUserAddresses;
import work.metanet.api.userAddress.protocol.ReqSaveUserAddress;
import work.metanet.api.userAddress.protocol.ReqSaveUserAddress.RespSaveUserAddress;
import work.metanet.api.userAddress.protocol.ReqUserAddressInfo.RespUserAddressInfo;
import work.metanet.base.service.CurdService;

public interface AddressService extends CurdService<UcUserAddresses> {
	
	/**
	 * @Description: 用户收货地址信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/29
	 */
	RespUserAddressInfo userAddressInfo(String userId) throws Exception;
	
	/**
	 * @Description: 保存用户收货地址
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/06/29
	 */
	RespSaveUserAddress saveUserAddress(String userId,ReqSaveUserAddress req) throws Exception;
	
	
}
