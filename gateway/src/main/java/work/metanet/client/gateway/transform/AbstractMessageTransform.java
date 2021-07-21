package work.metanet.client.gateway.transform;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.Resource;

/**
 * @Description 报文转换抽象类
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
public abstract class AbstractMessageTransform implements IMessageTransform {
    @Resource
    protected ObjectMapper objectMapper;

    /**
     * ResponseResult转JSON
     *
     * @param object 需要转换为json的对象
     * @return JSON字符串
     */
    public String toJsonString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

}
