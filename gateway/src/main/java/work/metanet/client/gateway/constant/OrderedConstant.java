package work.metanet.client.gateway.constant;

import org.springframework.core.Ordered;

import static org.springframework.cloud.gateway.filter.NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER;

/**
 * @Description filter排序码
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
public interface OrderedConstant extends Ordered {

    /**
     * 日志记录
     */
    int LOGGING_FILTER = WRITE_RESPONSE_FILTER_ORDER - 1;

    /**
     * 请求过滤器
     */
    int REQUEST_FILTER = HIGHEST_PRECEDENCE;

}
