package work.metanet.controller;

import javax.servlet.http.HttpServletRequest;

import work.metanet.api.openDevice.vo.OpenDeviceToken;
import work.metanet.exception.MetanetExceptionAssert;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.utils.HttpServletRequestUtil;
import work.metanet.utils.token.TokenUtil;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class BaseController {
	
	public OpenDeviceToken getOpenDeviceToken() throws Exception{
		String token = HttpServletRequestUtil.getRequest().getHeader("Authorization");
		return JSONUtil.toBean(TokenUtil.getPayloadSub(token), OpenDeviceToken.class);
	}
	
	public String getAppId() throws Exception {
		String appId = null;
		HttpServletRequest request = HttpServletRequestUtil.getRequest();
		if("/api/device/auth".equals(request.getRequestURI())) {
    		appId = new JSONObject(ServletUtil.getBody(request)).getStr("appId");
    	}else {
    		appId = getOpenDeviceToken().getAppId();
    	}
//		if(StrUtil.isBlank(appId)) throw MetanetException.of().setResult(ResultResponseEnum.FAILURE_REQUEST_PARAM.result().setMsg("appId is not empty"));
		MetanetExceptionAssert.assertTrue(StrUtil.isBlank(appId), ResultResponseEnum.INVALID_REQUEST.getResponseCode(), "%s", "appId is not empty");
		return appId;
	}
	
	public String getDeviceId() throws Exception {
		return getOpenDeviceToken().getDeviceId();
	}
	
}
