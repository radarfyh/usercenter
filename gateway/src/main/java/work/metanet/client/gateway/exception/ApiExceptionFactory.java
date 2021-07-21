package work.metanet.client.gateway.exception;

import org.apache.commons.lang.StringUtils;

/**
 * @Description api异常工厂
 *  @author EdisonFeng
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
public interface ApiExceptionFactory {
    String prefix();

    default ApiException apply(String code, String msg) {
        String prefix = prefix();
        prefix = StringUtils.isBlank(prefix) ? "" : prefix;
        return new ApiException(prefix + code, msg);
    }

}
