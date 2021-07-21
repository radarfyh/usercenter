package work.metanet.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import work.metanet.api.openAppBusinessCdk.protocol.ReqOpenAppBusinessCdkList;
import work.metanet.api.openAppBusinessCdk.protocol.ReqOpenAppBusinessCdkList.RespOpenAppBusinessCdkList;
import work.metanet.api.openAppBusinessCdk.protocol.ReqOpenAppBusinessCdkRemove;
import work.metanet.model.OpenAppBusinessCdk;

import tk.mybatis.mapper.common.Mapper;

public interface OpenAppBusinessCdkMapper extends Mapper<OpenAppBusinessCdk>{
	
	String getOpenAppBusinessCdk(@Param("openDeviceId")String openDeviceId,@Param("appId")String appId,@Param("businessCode")String businessCode);
	
	List<RespOpenAppBusinessCdkList> appBusinessCdkList(ReqOpenAppBusinessCdkList req);
	
	int removeAppBusinessCdk(@Param("list")List<ReqOpenAppBusinessCdkRemove> list);
}
