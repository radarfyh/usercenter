package work.metanet.third;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import work.metanet.constant.Constant;
import work.metanet.utils.LxSignUtil;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class YumushijiaApi {

	@Autowired Constant constant;
	
	private Map<String, String> initHeaders() {
		String timestamp = Convert.toStr(DateUtil.currentSeconds());
		String nonce = RandomUtil.randomString(6);
		return MapUtil.builder(new HashMap<String,String>()).put("timestamp", timestamp).put("nonce", nonce).build();
	}
	
	private String sign(Map<String, String> headers, Map<String, Object> body) {
		Map<String, Object> signMap = new HashMap<String,Object>();
		headers.forEach((k,v)->{
			signMap.put(k, v);
		});
		body.forEach((k,v)->{
			signMap.put(k, v);
		});
		signMap.put("secret", constant.getYmsjSignSecret());
		return LxSignUtil.getDigestStr_sha256(signMap);
	}
	
	private HttpRequest initHttpRequest(String url) {
		return HttpUtil.createPost(url).contentType(ContentType.JSON.getValue());
	}
	
	@Async
	public void syncUser(String userId, String phone) {
		Map<String, String> headers = initHeaders();
		Map<String, Object> body = MapUtil.builder(new HashMap<String,Object>())
				.put("userId", userId)
				.put("phone", phone)
				.build();
		
		HttpResponse httpResponse = initHttpRequest(constant.getYmsjDomain()+"/openapi/user/syncUser")
				.addHeaders(headers)
				.header("sign", sign(headers, body))
				.body(JSONUtil.toJsonStr(body))
				.execute()
				;
		
		log.info("-------------->"+httpResponse.body());
	}
	
}
