package work.metanet.client.user.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.DubboReference;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import work.metanet.client.user.security.SecurityUtils;
import com.alibaba.fastjson.JSONObject;
import work.metanet.server.usercenter.service.LogsService;
import work.metanet.server.usercenter.domain.UcLogs;
import work.metanet.utils.HttpUtils;
import work.metanet.utils.IPUtils;


/**
 * 系统日志，切面处理类，记录日志
 * @author Edison F.
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
@Aspect
@Component
public class SysLogAspect {
	
	@DubboReference
	private LogsService logsService;
	
	@Pointcut("execution(* work.metanet.server.usercenter.service.*.*(..))")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		// 执行方法
		Object result = point.proceed();
		// 执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		// 保存日志
		saveSysLog(point, time);
		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		String userName = SecurityUtils.getUsername();
		if(joinPoint.getTarget() instanceof LogsService) {
			return ;
		}
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		UcLogs sysLog = new UcLogs();
		
//		Method method = signature.getMethod();
//		com.wwater.merak.admin.annotation.SysLog syslogAnno = method.getAnnotation(com.wwater.merak.admin.annotation.SysLog.class);
//		if(syslogAnno != null){
//			//注解上的描述
//			sysLog.setOperation(syslogAnno.value());
//		}

		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		// 请求的参数
		Object[] args = joinPoint.getArgs();
		try{
			String params = JSONObject.toJSONString(args[0]);
			if(params.length() > 200) {
				params = params.substring(0, 200) + "...";
			}
			sysLog.setParams(params);
		} catch (Exception e){
		}

		// 获取request
		HttpServletRequest request = HttpUtils.getHttpServletRequest();
		// 设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));

		// 用户名
		sysLog.setUserName(userName);
		
		// 执行时长(毫秒)
		sysLog.setTime(time);
		
		// 保存系统日志
		logsService.save(sysLog);
	}
}
