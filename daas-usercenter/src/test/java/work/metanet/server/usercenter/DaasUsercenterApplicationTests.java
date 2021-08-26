package work.metanet.server.usercenter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import work.metanet.api.user.IUserService;
import work.metanet.api.user.protocol.ReqUserList;
import work.metanet.base.page.MyPageHelper;
import work.metanet.base.page.MyPageRequest;
import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.server.usercenter.vo.EmailAddress;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.hutool.json.JSONUtil;

@SpringBootTest
class DaasUsercenterApplicationTests {
	//远程调用注入接口类
	@DubboReference IUserService iUserSerivce;
	
	@Test
	void userList() throws Exception {
		System.out.println(JSONUtil.toJsonStr(iUserSerivce.userList(new ReqUserList())));;
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testUser() {
		UcUsers user = new UcUsers();
		EmailAddress email = new EmailAddress("test@hotmail.com");
		user.setEmail(email.getValue());
		assertEquals(user.getEmail(), email);
	}
	
	@Test
	void testRequest() {
		String json = "{\"pageNum\":1,\"pageSize\":10,\"columnFilters\":{\"name\":{\"name\":\"username\",\"value\":\"陆八\"}}}";
		MyPageRequest req = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
			req = mapper.readValue(json, MyPageRequest.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String name = MyPageHelper.getColumnFilterValue(req, "name");
        
        assertEquals(name, "陆八");
	}
}
