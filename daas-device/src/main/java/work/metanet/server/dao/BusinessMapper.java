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

import work.metanet.api.business.protocol.ReqBusinessInfo.RespBusinessInfo;
import work.metanet.api.business.protocol.ReqBusinessList.RespBusinessList;
import work.metanet.api.business.protocol.ReqRemoveBusiness;
import work.metanet.model.Business;

import tk.mybatis.mapper.common.Mapper;

public interface BusinessMapper extends Mapper<Business>{
	
	List<Map<String, Object>> getBusinessTree();
	
	Business getBusiness(Map<String, Object> map);
	
	RespBusinessInfo businessInfo(Map<String, Object> map);
	
	/**
	 * @Description: 列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	List<RespBusinessList> businessList(Map<String, Object> map);
	
	/**
	 * @Description: 删除内容商
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	int removeBusiness(@Param("list")List<ReqRemoveBusiness> list);
	
}
