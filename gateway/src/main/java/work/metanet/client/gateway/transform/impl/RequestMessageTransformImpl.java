package work.metanet.client.gateway.transform.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cn.hutool.core.bean.BeanUtil;
import work.metanet.client.gateway.properties.entity.MessageTransformUrl;
import work.metanet.client.gateway.transform.AbstractMessageTransform;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @Description application/json类型请求消息转换实现类
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Service
@Slf4j
public class RequestMessageTransformImpl extends AbstractMessageTransform {

    @Override
    public String transform(String originalContent, MessageTransformUrl transformUrl) {
    	// 调试信息
//        log.info("Request-->transform-->originalContent:{},transformUrl:{}", originalContent, transformUrl);
        
//        originalContent = "{\"pageNum\":1,\"pageSize\":10,\"columnFilters\":{\"name\":[{\"name\":\"name\",\"value\":\"陆八\"},{\"name\":\"sex\",\"value\":\"1\"}]}}";
        
        // 判断原始内容是否为空
        if (StringUtils.isBlank(originalContent)) {
            return originalContent;
        }

        try {
            // 原始报文转换为JsonNode
            JsonNode jsonNode = objectMapper.readTree(originalContent);

            // 获取请求消息转换字段列表
            List<String> fields = transformUrl.getRequestFields();

            // 创建新的JSON对象
            ObjectNode rootNode = objectMapper.createObjectNode();
            
            // 处理每个字段
            fields.forEach(field -> {
            	
            	// 提取每行配置中的三个域
                String[] fieldArray = field.split(":");
                // 第一个域：旧字段名
                String oldField = fieldArray[0];
                // 第二个域：新字段名
                String newField = fieldArray.length > 1 ? fieldArray[1] : oldField;
                // 第三个域：转换类型
                Integer type = fieldArray.length > 2 ? Integer.parseInt(fieldArray[2]) : 1;
                
                // 调试信息
                log.info("Request-->transform-->newFiled:{} oldField:{} type:{}", newField,oldField,type);
                
                switch(type) {
	                case 2: // 对象转换为键值
	                    if (jsonNode.has(oldField)) {
	                    	rootNode.set(newField, (JsonNode)BeanUtil.beanToMap(jsonNode.get(oldField)));
	                    }
	                    break;
	                case 3: // 键值转换为对象
	                    if (jsonNode.has(oldField)) {
	                    	Class<?> cls = null;
							try {
								cls = Class.forName(newField);
							} catch (ClassNotFoundException e) {
								log.error("Request-->transform-->错误原因：{} newFiled：{} ", e.getMessage(), newField);
								e.printStackTrace();
							}
	                    	rootNode.set(newField, (JsonNode)BeanUtil.toBean(jsonNode.get(oldField), cls));
	                    }
	                    break;
	                case 4: // 自定义
	                    if (jsonNode.has(oldField)) {
							if (oldField.equals("columnFilters")) {
								List<JsonNode> jsonFilters = jsonNode.findValues("columnFilters");

							    //遍历存放所有key的Set集合
							    Iterator<JsonNode> it =jsonFilters.iterator();
							    while (it.hasNext()) {   //利用了Iterator迭代器
							        //得到每一个key
							        JsonNode key = it.next();
							        
							        //通过key获取对应的value
							        Iterator<JsonNode> itDeep =key.iterator();
							        while (itDeep.hasNext()) {
							            //得到每一个key
							            JsonNode keyDeep = itDeep.next();
							            JsonNode nameNode = keyDeep.get("name");
							            JsonNode valueNode = keyDeep.get("value");
							            String str = "{"+nameNode+": "+valueNode.textValue()+"}";
							            try {
											JsonNode node = objectMapper.readTree(str);
											String fieldName = nameNode.textValue();

											JsonNode newNode = node.get(fieldName);
											rootNode.set(nameNode.textValue(), newNode);
										} catch (JsonProcessingException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
							        }
							    }
							}
	                    }
	                    break;
	                case 1: // 值和结构不变，只是变换字段名称
	                default:
	                    if (jsonNode.has(oldField)) {
	                        rootNode.set(newField, jsonNode.get(oldField));
	                    }
                }

            });
            
            log.info("Request-->transform-->originalContent:{}-->transformUrl:{}-->rootNode:{}", originalContent, transformUrl, rootNode);
            
            return toJsonString(rootNode);
        } catch (JsonProcessingException e) {
            log.error("Request-->transform-->application/json类型转换异常,error: {}, originalContent:{}", e.getMessage(), originalContent);
            return originalContent;
        }
    }
}
