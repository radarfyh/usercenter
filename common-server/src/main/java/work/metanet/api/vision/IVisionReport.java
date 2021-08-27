package work.metanet.api.vision;

import java.util.List;

import work.metanet.api.vision.protocol.ReqRecommendVisionReport;
import work.metanet.api.vision.protocol.ReqRecommendVisionReport.RespRecommendReportList;
import work.metanet.api.vision.protocol.ReqRemoveVisionReport;
import work.metanet.api.vision.protocol.ReqSaveVisionReport;
import work.metanet.api.vision.protocol.ReqSaveVisionReport.RespSaveVisionReport;
import work.metanet.api.vision.protocol.ReqSearchVisionReport;
import work.metanet.api.vision.protocol.ReqSearchVisionReport.RespSearchReportList;
import work.metanet.api.vision.protocol.ReqVisionReportInfo;
import work.metanet.api.vision.protocol.ReqVisionReportInfo.RespVisionReportInfo;
import work.metanet.api.vision.protocol.ReqVisionReportList;
import work.metanet.api.vision.protocol.ReqVisionReportList.RespVisionReportList;
import work.metanet.base.RespPaging;

/**
 * @author EdisonFeng
 * @Description 类IVisionReport, 视力报告接口类，用于RPC服务
 * @DateTime 2021年4月21日
 * Copyright(c) 2021. All Rights Reserved
 */
public interface IVisionReport {
	/**
	 * @Description: 查询视力报告列表
	 * @Author Edison F.
	 * @DateTime 2021/07/20
	 */
	RespPaging<RespVisionReportList> getVisionReportList(ReqVisionReportList req) throws Exception;
	
	/**
	 * @Description: 查询视力报告详情
	 * @Author Edison F.
	 * @DateTime 2021/07/20
	 */
	RespVisionReportInfo getVisionReportInfo(ReqVisionReportInfo req) throws Exception;
	
	/**
	 * @Description: 修改报告信息，不存在报告ID则自动新增
	 * @Author Edison F.
	 * @DateTime 2021/07/20
	 */
	RespSaveVisionReport saveVisionReport(ReqSaveVisionReport req) throws Exception;
	
	/**
	 * @Description: 增加报告信息
	 * @Author Edison F.
	 * @DateTime 2021/07/03
	 */
	RespSaveVisionReport insertVisionReport(ReqSaveVisionReport req) throws Exception;
	
	/**
	 * @Description: 删除视力报告信息
	 * @Author Edison F.
	 * @DateTime 2021/07/20
	 */
	String removeVisionReport(List<ReqRemoveVisionReport> tests) throws Exception;
	
	/**
	 * @Description: 推荐报告信息
	 * @Author Edison F.
	 * @DateTime 2021/07/23
	 */
	RespPaging<RespRecommendReportList> recommendVisionReport(ReqRecommendVisionReport req) throws Exception;
	
	/**
	 * @Description: 搜索视力报告信息
	 * @Author Edison F.
	 * @DateTime 2021/07/23
	 */
	RespPaging<RespSearchReportList> searchVisionReport(ReqSearchVisionReport req) throws Exception;
}
