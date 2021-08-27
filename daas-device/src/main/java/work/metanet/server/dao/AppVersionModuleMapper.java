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
import org.apache.ibatis.annotations.Update;

import work.metanet.api.versionModule.protocol.ReqAppVersionModuleInfo.RespAppVersionModuleInfo;
import work.metanet.api.versionModule.protocol.ReqAppVersionModuleList.RespAppVersionModuleList;
import work.metanet.api.versionModule.protocol.ReqRemoveAppVersionModule;
import work.metanet.api.versionModule.protocol.ReqViewAppVersionModule.RespViewAppVersionModule;
import work.metanet.model.AppVersionModule;

import tk.mybatis.mapper.common.Mapper;

public interface AppVersionModuleMapper extends Mapper<AppVersionModule>{
	
	/**
	 * @Description: 产品模块展示
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespViewAppVersionModule viewAppVersionModule(@Param("packageName")String packageName,@Param("versionCode")String versionCode);
	
	AppVersionModule getAppVersionModule(Map<String, Object> map);
	
	/**
	 * @Description: 版本模块详情
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespAppVersionModuleInfo appVersionModuleInfo(Map<String, Object> map);
	
	/**
	 * @Description: 版本模块列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	List<RespAppVersionModuleList> appVersionModuleList(Map<String, Object> map);
	
	/**
	 * @Description: 删除版本模块
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	int removeAppVersionModule(@Param("list")List<ReqRemoveAppVersionModule> list);
	
	/**
	 * @Description: 修改父级节点
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	@Update("update t_app_version_module set parent_id=#{parentId} where version_module_id=#{versionModuleId}")
	int updAppVersionModuleParent(@Param("versionModuleId")String versionModuleId,@Param("parentId")String parentId);

	
}
