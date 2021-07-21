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

import java.util.List;

/**
 * @Description application/json类型响应消息转换实现类
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Service
@Slf4j
public class JsonMessageTransformImpl extends AbstractMessageTransform {

    @Override
    public String transform(String originalContent, MessageTransformUrl transformUrl) {
//        log.info("Response-->transform-->originalContent:{},transformUrl:{}", originalContent, transformUrl);

        if (StringUtils.isBlank(originalContent)) {
            return originalContent;
        }

        try {
            // 原始报文转换为JsonNode
            JsonNode jsonNode = objectMapper.readTree(originalContent);

            List<String> fields = transformUrl.getResponseFields();

            // 创建新的JSON对象
            ObjectNode rootNode = objectMapper.createObjectNode();
            fields.forEach(field -> {
                String[] fieldArray = field.split(":");
                String newField = fieldArray[0];
                String oldField = fieldArray.length > 1 ? fieldArray[1] : newField;
                Integer type = fieldArray.length > 2 ? Integer.parseInt(fieldArray[2]) : 1;
                
                log.info("Response-->transform-->newFiled:{} oldField:{} type:{}", newField,oldField,type);
                
                switch(type) {
	                case 2:
	                    if (jsonNode.has(oldField)) {
	                    	rootNode.set(newField, (JsonNode)BeanUtil.beanToMap(jsonNode.get(oldField)));
	                    }
	                    break;
	                case 3:
	                    if (jsonNode.has(oldField)) {
	                    	Class<?> cls = null;
							try {
								cls = Class.forName(newField);
							} catch (ClassNotFoundException e) {
								log.error("Response-->transform-->错误原因：{} newFiled：{} oldField：{} type：{}", 
										e.getMessage(), newField, oldField, type);
								e.printStackTrace();
							}
							
	                    	Object obj = jsonNode.get(newField);
	                    	
	                    	rootNode.set(newField, (JsonNode) BeanUtil.toBean(obj, cls));
	                    }
	                    break;
	                case 1:
	                default:
	                    if (jsonNode.has(oldField)) {
	                        rootNode.set(newField, jsonNode.get(oldField));
	                    }
                }

            });
            
            log.info("Response-->transform-->originalContent:{}-->transformUrl:{}-->rootNode:{}", originalContent, transformUrl, rootNode);

            return toJsonString(rootNode);
        } catch (JsonProcessingException e) {
            log.error("Response-->transform-->application/json类型转换异常,error: {}, originalContent:{}", e.getMessage(), originalContent);
            return originalContent;
        }
    }
}
