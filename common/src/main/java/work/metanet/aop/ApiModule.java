package work.metanet.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 模块
 * @Author Louis & Edison & W.B.
 * @DateTime 2019/11/13
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiModule {
	
	/**
	 * @Description: 模块
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/13
	 */
	Module module();
	
	@Getter
	@AllArgsConstructor
	enum Module {
		USER("用户"),
		ADMIN("管理后台"), 
		DEVICE("设备"), 
		CHANNEL("渠道"), 
		BRAND("品牌"), 
		MODEL("型号"), 
		SN("SN码"), 
		APP("产品"),
		FAMILY("家庭成员"),
		VERSION("版本"), 
		UPGRADE_PLAN("升级计划"),
		LOG("日志"),
		FILE("文件"),
		STATISTICAL("统计"),
		VERSION_MODULE("产品版本模块"),
		FEEDBACK("问题反馈"),
		STORE_APP("应用商店"),
		ROLE("角色"),
		PERMISSION("权限"),
		REGION("区域"),
		OPEN_DEVICE("开放平台-设备"),
		OPEN_APP("开放平台-应用"), 
		OPEN_APP_BUSINESS("开放平台-应用业务"),
		;
		String val;
	}
	
}
