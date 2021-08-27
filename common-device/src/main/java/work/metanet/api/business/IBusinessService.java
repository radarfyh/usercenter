package work.metanet.api.business;

import java.util.List;

import work.metanet.api.business.protocol.ReqBusinessInfo;
import work.metanet.api.business.protocol.ReqBusinessInfo.RespBusinessInfo;
import work.metanet.api.business.protocol.ReqBusinessList;
import work.metanet.api.business.protocol.ReqRemoveBusiness;
import work.metanet.api.business.protocol.ReqBusinessList.RespBusinessList;
import work.metanet.api.business.protocol.ReqSaveBusiness;
import work.metanet.api.business.protocol.ReqSaveBusiness.RespSaveBusiness;
import work.metanet.base.RespPaging;

public interface IBusinessService {

	/**
	 * @Description: 内容商列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespPaging<RespBusinessList> businessList(ReqBusinessList req) throws Exception;
	
	/**
	 * @Description: 内容商详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespBusinessInfo businessInfo(ReqBusinessInfo req) throws Exception;
	
	/**
	 * @Description: 保存内容商
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespSaveBusiness saveBusiness(ReqSaveBusiness req) throws Exception;
	
	/**
	 * @Description: 删除内容商
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removeBusiness(List<ReqRemoveBusiness> req) throws Exception;
	
	
}
