/**  
 * @Title: OrderMapper.java
 * @Description: TODO
 * @Author Louis & Edison & W.B.
 * @date 2018年3月28日
 */
package work.metanet.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import work.metanet.api.businessApp.protocol.ReqBusinessAppInfo.RespBusinessAppInfo;
import work.metanet.api.businessApp.protocol.ReqBusinessAppList.RespBusinessAppList;
import work.metanet.api.businessApp.protocol.ReqRemoveBusinessApp;
import work.metanet.api.businessApp.vo.BusinessAppVo;
import work.metanet.model.BusinessApp;

import tk.mybatis.mapper.common.Mapper;

public interface BusinessAppMapper extends Mapper<BusinessApp>{
	
	/**
	 * @Description: 获取内容商最新产品
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/27
	 */
	BusinessAppVo latestBusinessApp(@Param("businessCode")String businessCode,@Param("packageName")String packageName);
	
	List<Map<String, Object>> getBusinessAppTree(Map<String, Object> map);
	
	BusinessApp getBusinessApp(Map<String, Object> map);
	
	RespBusinessAppInfo businessAppInfo(Map<String, Object> map);
	
	/**
	 * @Description: 列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	List<RespBusinessAppList> businessAppList(Map<String, Object> map);
	
	/**
	 * @Description: 删除
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	int removeBusinessApp(@Param("list")List<ReqRemoveBusinessApp> list);
	
}
