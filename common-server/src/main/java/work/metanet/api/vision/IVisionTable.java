package work.metanet.api.vision;

import java.util.List;

import work.metanet.api.vision.protocol.ReqRemoveVisionTable;
import work.metanet.api.vision.protocol.ReqSaveVisionTable;
import work.metanet.api.vision.protocol.ReqSaveVisionTable.RespSaveVisionTable;
import work.metanet.api.vision.protocol.ReqVisionTableInfo;
import work.metanet.api.vision.protocol.ReqVisionTableList;
import work.metanet.api.vision.protocol.ReqVisionTableInfo.RespVisionTableInfo;
import work.metanet.api.vision.protocol.ReqVisionTableList.RespVisionTableList;
import work.metanet.base.RespPaging;

/**
 * @author Edison F.
 * @Description 视力表
 * @DateTime 2021/05/1
 */
public interface IVisionTable {
	/**
	 * @Description: 查询视力表
	 * @Author Edison F.
	 * @DateTime 2021/05/1
	 */
	RespVisionTableInfo getVisionTableInfo(ReqVisionTableInfo req) throws Exception;
	
	RespPaging<RespVisionTableList> getVisionTableList(ReqVisionTableList req) throws Exception;
	
	RespSaveVisionTable saveVisionTable(ReqSaveVisionTable req) throws Exception;
	
	RespSaveVisionTable insertVisionTable(ReqSaveVisionTable req) throws Exception;
	
	String removeVisionTable(List<ReqRemoveVisionTable> tests) throws Exception;
}
