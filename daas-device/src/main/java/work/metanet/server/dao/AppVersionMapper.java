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

import work.metanet.api.version.protocol.ReqAppVersionInfo.RespAppVersionInfo;
import work.metanet.api.version.protocol.ReqAppVersionList.RespAppVersionList;
import work.metanet.api.version.protocol.ReqRemoveAppVersion;
import work.metanet.model.AppVersion;

import tk.mybatis.mapper.common.Mapper;

public interface AppVersionMapper extends Mapper<AppVersion>{
	
	AppVersion getAppVersion(Map<String, Object> map);
	
	/**
	 * @Description: 版本详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespAppVersionInfo appVersionInfo(Map<String, Object> map);
	
	/**
	 * @Description: 版本列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	List<RespAppVersionList> appVersionList(Map<String, Object> map);
	
	/**
	 * @Description: 删除版本
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	int removeAppVersion(@Param("list")List<ReqRemoveAppVersion> list);
	
}
