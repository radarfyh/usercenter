/**
 * @Description 文件：AbstractMockMvcTest.java
 * @author EdisonFeng
 * @DateTime 2021年6月7日
 * Copyright(c) 2021. All Rights Reserved
 */
package work.metanet.client.user;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author EdisonFeng
 *
 */
public abstract class AbstractMockMvcTest {

    private static final Logger logger = LoggerFactory.getLogger(AbstractMockMvcTest.class);

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockMvcTestConfig config;


    /**
     * 设置测试的一些参数.
     * @param mockMvcTestConfig 参数封装
     * @throws Exception 为空抛出异常
     */
    public void prepareTestConfig(MockMvcTestConfig mockMvcTestConfig) throws Exception {
        if(mockMvcTestConfig == null) {
            throw new Exception("test config is null");
        }

        this.config = mockMvcTestConfig;
    }

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 执行接口请求
     * @return MvcResult
     * @throws Exception 不支持的方法抛出异常
     */
    public MvcResult endpointTestTrigger() throws Exception {

        RequestMethod method = this.config.method;
        String endpoint = this.config.endpoint;
        Object parameter = this.config.parameter;
        Map<String, String> headers = this.config.headers;

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder;

        HttpHeaders httpHeaders = new HttpHeaders();
        // 请求带有请求头
        if(headers != null && !headers.isEmpty()) {
            for(Map.Entry<String, String> entry : headers.entrySet()) {
                httpHeaders.add(entry.getKey(), entry.getValue());
            }
        }

        if(RequestMethod.GET.equals(method)) {
            mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(endpoint).headers(httpHeaders);

        } else if(RequestMethod.POST.equals(method)) {
            String json = JSON.toJSONString(parameter, SerializerFeature.WriteMapNullValue);
            logger.info("post request body:{}", json);

            mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(endpoint)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)
                    .headers(httpHeaders)
                    .accept(MediaType.APPLICATION_JSON);

        } else if(RequestMethod.PUT.equals(method)) {
            String json = JSON.toJSONString(parameter, SerializerFeature.WriteMapNullValue);
            logger.info("put request body:{}", json);

            mockHttpServletRequestBuilder = MockMvcRequestBuilders.put(endpoint)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)
                    .headers(httpHeaders)
                    .accept(MediaType.APPLICATION_JSON);

        } else if(RequestMethod.DELETE.equals(method)) {
            mockHttpServletRequestBuilder = MockMvcRequestBuilders.delete(endpoint).headers(httpHeaders);

        } else {
            throw new Exception("mock test not support http method: " + method.name());
        }

        MvcResult result = mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        logger.info(result.getResponse().getContentAsString());
        return result;
    }


    /**
     * 测试相关参数封装
     */
    final class MockMvcTestConfig {
        /**
         * 请求接口的uri
         */
        String endpoint;
        /**
         * 请求参数体
         */
        Object parameter;
        /**
         * 接口支持http方法
         */
        RequestMethod method;

        /**
         * 请求头
         */
        Map<String, String> headers;
    }

}
