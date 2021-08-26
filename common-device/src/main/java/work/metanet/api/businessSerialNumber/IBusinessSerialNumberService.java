package work.metanet.api.businessSerialNumber;

import java.util.List;

import work.metanet.api.businessSerialNumber.protocol.ReqBusinessSerialNumberList;
import work.metanet.api.businessSerialNumber.protocol.ReqBusinessSerialNumberList.RespBusinessSerialNumberList;
import work.metanet.api.businessSerialNumber.protocol.ReqGetBusinessSn;
import work.metanet.api.businessSerialNumber.protocol.ReqGetBusinessSn.RespGetBusinessSn;
import work.metanet.api.businessSerialNumber.protocol.ReqImportBusinessSerialNumber;
import work.metanet.api.businessSerialNumber.protocol.ReqRemoveBusinessSerialNumber;
import work.metanet.api.businessSerialNumber.protocol.ReqRestoreSn;
import work.metanet.api.businessSerialNumber.protocol.ReqUpdBusinessSnUseStatus;
import work.metanet.base.RespPaging;

public interface IBusinessSerialNumberService {
	
	/**
	 * @Description: 内容商激活码列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	RespPaging<RespBusinessSerialNumberList> businessSerialNumberList(ReqBusinessSerialNumberList req) throws Exception;
	
	/**
	 * @Description: 内容商激活码导入
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/12/03
	 */
	void importBusinessSerialNumber(ReqImportBusinessSerialNumber req) throws Exception;
	
	/**
	 * @Description: 删除内容商激活码
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	void removeBusinessSerialNumber(List<ReqRemoveBusinessSerialNumber> businessSerialNumbers) throws Exception;
	
	/**
	 * @Description: 修复内容商激活码
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/11
	 */
	void restoreSn(List<ReqRestoreSn> list)throws Exception;
	
	/**
	 * @Description: 获取内容商激活码
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/02
	 */
	List<RespGetBusinessSn> getBusinessSn(String packageName,String deviceId,List<ReqGetBusinessSn> req) throws Exception;
	
	/**
	 * @Description: 更新内容商激活码使用状态
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/01/10
	 */
	void updBusinessSnUseStatus(String packageName,String versionCode,String deviceId,ReqUpdBusinessSnUseStatus req) throws Exception;
	
}
