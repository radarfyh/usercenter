package work.metanet.client.gateway.properties;

import work.metanet.client.gateway.properties.entity.MessageTransformUrl;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 报文结构转换参数配置
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */

@Component
@ConfigurationProperties(prefix = "trans")
@Data
public class MessageTransformProperties {

    private List<MessageTransformUrl> urlList;

}
