package work.metanet.client.gateway;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import work.metanet.client.gateway.properties.MessageTransformProperties;
import work.metanet.client.gateway.properties.entity.MessageTransformUrl;
import work.metanet.client.gateway.vo.ColumnFilter;
import work.metanet.client.gateway.vo.MyPageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
@WebFluxTest
//@SpringBootTest(properties = "spring.main.web-application-type=reactive")
//@AutoConfigureWebTestClient
@Slf4j
class GatewayApplicationTests {
//    @Resource
//    protected ObjectMapper objectMapper;
//    @Resource
//    private MessageTransformProperties messageTransformProperties;
    
//	@Test
//	void contextLoads() {
//	}
	
//	@Test
//	void testRequestTrans() {
//		
//		String originalContent = "{\"pageNum\":1,\"pageSize\":10,\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"陆八\"}}}";
//		
//		List<MessageTransformUrl> urlList = messageTransformProperties.getUrlList();
//		MessageTransformUrl transformUrl = urlList.get(0);
//		
//        // 判断原始内容是否为空
//        if (StringUtils.isBlank(originalContent)) {
//            return;
//        }
//
//        try {
//            // 原始报文转换为JsonNode
//            JsonNode jsonNode = objectMapper.readTree(originalContent);
//
//            // 获取请求消息转换字段列表
//            List<String> fields = transformUrl.getRequestFields();
//
//            // 创建新的JSON对象
//            ObjectNode rootNode = objectMapper.createObjectNode();
//            
//            // 处理每个字段
//            fields.forEach(field -> {
//            	
//            	// 提取每行配置中的三个域
//                String[] fieldArray = field.split(":");
//                // 第一个域：新字段名
//                String newFiled = fieldArray[0];
//                // 第一个域：旧字段名
//                String oldField = fieldArray.length > 1 ? fieldArray[1] : newFiled;
//                // 第一个域：转换类型
//                Integer type = fieldArray.length > 2 ? Integer.parseInt(fieldArray[2]) : 1;
//                
//                // 调试信息
//                log.info("RequestMessageTransformImpl--》transform --> fields.forEach --> newFiled:{} oldField:{} type:{}", newFiled,oldField,type);
//                
//                switch(type) {
//	                case 2: // 对象转换为键值
//	                    if (jsonNode.has(oldField)) {
//	                    	rootNode.set(newFiled, (JsonNode)BeanUtil.beanToMap(jsonNode.get(oldField)));
//	                    }
//	                    break;
//	                case 3: // 键值转换为对象
//	                	log.info("transform --> fields.forEach --> jsonNode:{}", jsonNode);
//	                    if (jsonNode.has(oldField)) {
//							try {
//								if (oldField.equals("columnFilters")) {
//									// MyPageRequest req = new MyPageRequest();
//									Class<?> clazz = Class.forName("MyPageRequest");
//									MyPageRequest req = (MyPageRequest) BeanUtil.toBean(jsonNode, clazz);
//									Map<String, ColumnFilter> columnFilters = req.getColumnFilters();
//
//							        //获取Map中的所有key
//							        Set<String> keySet = columnFilters.keySet();
//							        //遍历存放所有key的Set集合
//							        Iterator<String> it =keySet.iterator();
//							        while (it.hasNext()) {   //利用了Iterator迭代器
//							            //得到每一个key
//							            String key = it.next();
//							            
//							            JsonNode keyNode = jsonNode.get(key);
//							            //通过key获取对应的value
//							            ColumnFilter value = columnFilters.get(key);
//							            JsonNode valueNode = keyNode.get(value.getValue());
//							            
//							            rootNode.set(value.getName(), valueNode);
//							        }
//								}
//
//		                    	log.info("transform --> fields.forEach --> rootNode:{}", rootNode);
//							} catch (ClassNotFoundException e) {
//								log.error("错误原因：{} newFiled：{} oldField：{} type：{}", 
//										e.getMessage(), newFiled, oldField, type);
//								e.printStackTrace();
//							}
//	                    }
//	                    break;
//	                case 1: // 值和结构不变，只是变换字段名称
//	                default:
//	                    if (jsonNode.has(oldField)) {
//	                        rootNode.set(newFiled, jsonNode.get(oldField));
//	                    }
//                }
//
//            });
//
//
//        } catch (JsonProcessingException e) {
//            log.error("application/json类型转换异常,originalContent:{},transformUrl:{}", originalContent, transformUrl);
//
//        }
//	}
}
