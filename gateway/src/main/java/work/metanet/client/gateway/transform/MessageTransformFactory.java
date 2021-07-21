package work.metanet.client.gateway.transform;

import work.metanet.client.gateway.enums.TransformContentTypeEnum;
import work.metanet.client.gateway.filter.ResponseLogFilter;
import work.metanet.client.gateway.log.Log;
import work.metanet.client.gateway.properties.MessageTransformProperties;
import work.metanet.client.gateway.properties.entity.MessageTransformUrl;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 报文结构转换工厂类
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Component
@Slf4j
public class MessageTransformFactory {

    @Resource
    private Map<String, AbstractMessageTransform> messageTransformMap;

    @Resource
    private MessageTransformProperties messageTransformProperties;

    /**
     * 根据contentType获取对应的内容转换实现类
     *
     * @param contentType 内容类型
     * @return 内容转换实现类
     */
    private AbstractMessageTransform getMessageTransform(String contentType) {
        return messageTransformMap.get(TransformContentTypeEnum.getWithDefault(contentType).getTransImpl());
    }
    /**
     * 根据contentType获取对应的内容转换实现类
     *
     * @param logType           请求还是响应
     * @param contentType 内容类型
     * @return 内容转换实现类
     */
    private AbstractMessageTransform getMessageTransform(Log.TYPE logType, String contentType) {
        return messageTransformMap.get(TransformContentTypeEnum.getWithDefault(logType, contentType).getTransImpl());
    }
    /**
     * 报文转换
     *
     * @param originalContent 原始内容
     * @param transformUrl    url
     * @return 转换后的消息
     */
    private String messageTransform(String originalContent, MessageTransformUrl transformUrl) {
        String contentType = transformUrl.getContentType();
        AbstractMessageTransform messageTransform = getMessageTransform(contentType);
        
    	log.info("messageTransform -->transformUrl:{},originalContent:{}", transformUrl, originalContent);

        return messageTransform.transform(originalContent, transformUrl);
    }
    /**
     * 报文转换
     *
     * @param logType           请求还是响应
     * @param originalContent 原始内容
     * @param transformUrl    url
     * @return 转换后的消息
     */
    private String messageTransform(Log.TYPE logType, String originalContent, MessageTransformUrl transformUrl) {
        // 头部信息内容类型
    	String contentType = transformUrl.getContentType();
    	// 获取消息转换处理器
        AbstractMessageTransform messageTransform = getMessageTransform(logType, contentType);
        
        // 调试信息
    	log.info("messageTransform -->transformUrl:{},originalContent:{}", transformUrl, originalContent);

    	// 调用转换处理器的转换函数
        return messageTransform.transform(originalContent, transformUrl);
    }
    /**
     * 判断是否是需要转换报文结构的接口，如果是则转换，否则返回原值
     *
     * @param path            接口路径
     * @param originalContent 原始内容
     * @return 转换后的内容
     */
    public String compareAndTransform(String path, String originalContent) {
        if (StringUtils.isBlank(originalContent)) {
            return null;
        }
        List<MessageTransformUrl> urlList = messageTransformProperties.getUrlList();
        if (CollectionUtils.isEmpty(urlList)) {
            return originalContent;
        }
        return urlList
        		.stream()
                .filter(transformUrl -> transformUrl.getPathList().contains(path))
                .findFirst()
                .map(url -> messageTransform(originalContent, url))
                .orElse(originalContent);
    }
    /**
     * 判断是否是需要转换报文结构的接口，如果是则转换，否则返回原值
     *
     * @param logType           请求还是响应
     * @param path            接口路径
     * @param originalContent 原始内容
     * @return 转换后的内容
     */
    public String compareAndTransform(Log.TYPE logType, String path, String originalContent) {
        if (StringUtils.isBlank(originalContent)) {
            return null;
        }
        List<MessageTransformUrl> urlList = messageTransformProperties.getUrlList();
        if (CollectionUtils.isEmpty(urlList)) {
            return originalContent;
        }
        return urlList
        		.stream()
                .filter(transformUrl -> transformUrl.getPathList().contains(path))
                .findFirst()
                .map(url -> messageTransform(logType, originalContent, url))
                .orElse(originalContent);
    }
    /**
     * 判断是否是需要转换报文结构的接口，如果是则转换，否则返回原值
     *
     * @param path              接口路径
     * @param originalContent   原始内容
     * @param originalByteArray 二进制原始内容
     * @param charset           charset
     * @param newResponseBody   新报文内容
     * @return 响应体数组数组
     */
    public byte[] compareAndTransform(String path, String originalContent, byte[] originalByteArray, Charset charset,
                                      AtomicReference<String> newResponseBody) {
        log.info("compareAndTransform --> path:{},originalContent:{}", path, originalContent);

        if (StringUtils.isBlank(originalContent)) {
            return null;
        }
        List<MessageTransformUrl> urlList = messageTransformProperties.getUrlList();
        if (CollectionUtils.isEmpty(urlList)) {
            return originalByteArray;
        }
        return urlList
        		.stream()
                .filter(transformUrl -> transformUrl.getPathList().contains(path))
                .findFirst()
                .map(url -> {
                	
                	log.info("compareAndTransform -->urlList.map--> url:{},originalContent:{}", url, originalContent);
                	
                    String messageTransform = messageTransform(originalContent, url);
                    if (originalContent.equals(messageTransform)) {
                        return originalByteArray;
                    }
                    newResponseBody.set(messageTransform);
                    return messageTransform.getBytes(charset);
                })
                .orElse(originalByteArray);
    }
    
    /**
     * 判断是否是需要转换报文结构的接口，如果是则转换，否则返回原值
     *
     * @param logType           请求还是响应
     * @param path              接口路径
     * @param originalContent   原始内容
     * @param originalByteArray 二进制原始内容
     * @param charset           charset
     * @param newResponseBody   新报文内容
     * @return 响应体数组数组
     */
    public byte[] compareAndTransform(Log.TYPE logType, String path, String originalContent, byte[] originalByteArray, Charset charset,
                                      AtomicReference<String> newResponseBody) {
        log.info("compareAndTransform --> path:{},originalContent:{}", path, originalContent);

        // 原始内容为空则直接返回空
        if (StringUtils.isBlank(originalContent)) {
            return null;
        }
        
        // 获取yml配置，若没有配置，则直接返回原始字节组
        List<MessageTransformUrl> urlList = messageTransformProperties.getUrlList();
        if (CollectionUtils.isEmpty(urlList)) {
            return originalByteArray;
        }
        
        // 处理配置
        return urlList
        		.stream()
                .filter(transformUrl -> transformUrl.getPathList().contains(path)) // 对应链接是否有配置
                .findFirst() // 只处理第一个
                .map(url -> {
                	// 调试日志
                	log.info("compareAndTransform -->urlList.map--> url:{},originalContent:{}", url, originalContent);
                	
                	// 调用转换函数
                    String messageTransform = messageTransform(logType, originalContent, url);
                    if (originalContent.equals(messageTransform)) {
                        return originalByteArray;
                    }
                    newResponseBody.set(messageTransform);
                    return messageTransform.getBytes(charset);
                })
                .orElse(originalByteArray);
    }
}
