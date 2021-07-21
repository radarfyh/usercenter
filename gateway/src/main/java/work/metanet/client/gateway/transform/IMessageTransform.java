package work.metanet.client.gateway.transform;

import work.metanet.client.gateway.properties.entity.MessageTransformUrl;

/**
 * @Description 报文结构转换接口
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
public interface IMessageTransform {

    /**
     * 转换报文结构
     *
     * @param originalContent 需要转换的原始内容
     * @param transformUrl    MessageTransformUrl
     * @return 转换后的结构
     */
    String transform(String originalContent, MessageTransformUrl transformUrl);
}
