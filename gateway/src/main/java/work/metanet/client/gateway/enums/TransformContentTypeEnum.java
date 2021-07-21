package work.metanet.client.gateway.enums;

import lombok.Getter;
import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
import work.metanet.client.gateway.log.Log;

/**
 * @Description 报文结构转换转换类型枚举类
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Getter
public enum TransformContentTypeEnum {

    RESPONSE_DEFAULT(Log.TYPE.RESPONSE, null, "jsonMessageTransformImpl"), 
    RESPONSE_APPLICATION_JSON(Log.TYPE.RESPONSE, "application/json", "jsonMessageTransformImpl"),
    REQUEST_DEFAULT(Log.TYPE.REQUEST, null, "requestMessageTransformImpl"), 
    REQUEST_APPLICATION_JSON(Log.TYPE.REQUEST, "application/json", "requestMessageTransformImpl")
    ;
    
    /**
     * 日志类型（请求响应）
     */
    private Log.TYPE logType;
    
    /**
     * 内容类型
     */
    private String contentType;

    
    /**
     * 报文转换结构实现类
     */
    private String transImpl;

    TransformContentTypeEnum(Log.TYPE logType, String contentType, String transImpl) {
    	this.logType = logType;
        this.contentType = contentType;
        this.transImpl = transImpl;
    }

    /**
     * 根据contentType获取对应枚举
     * <p>
     * 如果contentType为空则返回默认枚举
     * </p>
     *
     * @param contentType contentType
     * @return TransformContentTypeEnum
     */
    public static TransformContentTypeEnum getWithDefault(@Nullable String contentType) {
        if (StringUtils.isNotBlank(contentType)) {
            for (TransformContentTypeEnum transformContentTypeEnum : values()) {
                if (contentType.equals(transformContentTypeEnum.contentType)) {
                    return transformContentTypeEnum;
                }
            }
        }
        return RESPONSE_DEFAULT;
    }
    
    /**
     * 根据contentType获取对应枚举
     * <p>
     * 如果contentType为空则返回默认枚举
     * </p>
     *
     * @param contentType 请求头的内容类型
     * @param logType 响应还是请求
     * @return TransformContentTypeEnum
     */
    public static TransformContentTypeEnum getWithDefault(@Nullable Log.TYPE logType,
    		@Nullable String contentType) {
        if (StringUtils.isNotBlank(contentType)) {
            for (TransformContentTypeEnum transformContentTypeEnum : values()) {
                if (logType.equals(transformContentTypeEnum.logType) &&
                		contentType.equals(transformContentTypeEnum.contentType)) {
                    return transformContentTypeEnum;
                }
            }
        }
        return RESPONSE_DEFAULT;
    }
}
