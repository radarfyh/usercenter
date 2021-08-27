package work.metanet.server.dao;

import org.apache.ibatis.annotations.Param;

import work.metanet.model.DeviceAppBusinessSnCode;

import tk.mybatis.mapper.common.Mapper;

public interface DeviceAppBusinessSnCodeMapper extends Mapper<DeviceAppBusinessSnCode>{

	
	/**
	 * @Description: 获取激活成功的激活码
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/10
	 */
	String getUseSuccessDeviceAppBusinessSnCode(@Param("businessCode")String businessCode,@Param("packageName")String packageName,@Param("deviceId")String deviceId);
	
}
