package work.metanet.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import work.metanet.api.businessSerialNumber.protocol.ReqBusinessSerialNumberList.RespBusinessSerialNumberList;
import work.metanet.api.businessSerialNumber.protocol.ReqRemoveBusinessSerialNumber;
import work.metanet.model.BusinessSerialNumber;

import tk.mybatis.mapper.common.Mapper;

public interface BusinessSerialNumberMapper extends Mapper<BusinessSerialNumber>{
	
	/**
	 * @Description: 获取SN码信息
	 * @Author wanbo
	 * @DateTime 2020/01/09
	 */
	BusinessSerialNumber getBusinessSerialNumber(Map<String, Object> map);

	/**
	 * @Description: SN码列表
	 * @Author wanbo
	 * @DateTime 2019/11/20
	 */
	List<RespBusinessSerialNumberList> businessSerialNumberList(Map<String, Object> map);
	
	/**
	 * @Description: 删除SN码
	 * @Author wanbo
	 * @DateTime 2019/11/20
	 */
	int removeBusinessSerialNumber(@Param("list")List<ReqRemoveBusinessSerialNumber> list);
	
}
