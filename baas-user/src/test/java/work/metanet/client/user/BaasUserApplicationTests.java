package work.metanet.client.user;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import work.metanet.client.user.controller.UsersController;

@SpringBootTest
class BaasUserApplicationTests {

    private MockMvc mvc;
    
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UsersController()).build();
    }
  
    // 1、get查一下user列表，应该为空
    @Test
    public void testGetUser() throws Exception {
        RequestBuilder request = null;
        request = get("/user/findByName")
        		.param("name", "edison");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")))
                .andDo(MockMvcResultHandlers.print());
    }
    
// 	//2、post提交一个user
//    @Test
//    public void testSave() throws Exception {
//
//        RequestBuilder request = null;
//        
//        request = post("/user/save")
//                .param("id", "1")
//                .param("name", "edison")
//                .param("age", "20");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("success")));
//    }
//    
//    // 3、get获取user列表，应该有刚才插入的数据
//    @Test
//    public void testGetList() throws Exception {
//        RequestBuilder request = get("/user/findPage");
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("[{\"id\":1,\"username\":\"edison\",\"age\":20}]")));
//    }
//    
//    @Test
//    public void testPutUserByID() throws Exception {
//        // 4、put修改id为1的user
//    	RequestBuilder request = put("/save/1")
//                .param("name", "tom")
//                .param("age", "30");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("success")));
//  
//    }
//    
//    @Test
//    public void testGetUserByID() throws Exception {
//        // 5、get一个id为1的user
//    	RequestBuilder request = get("/users/1");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"tom\",\"age\":30}")));
//     }
//    
//    @Test
//    public void testDeleteByID() throws Exception {
//        // 6、del删除id为1的user
//    	RequestBuilder request = delete("/users/1");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("success")));
//    }
//    
//    @Test
//    public void testUserController() throws Exception {
//  
//        // 7、get查一下user列表，应该为空
//    	RequestBuilder request = get("/users/");
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("[]")));
//  
//    }
 
}
