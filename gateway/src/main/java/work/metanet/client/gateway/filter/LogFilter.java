package work.metanet.client.gateway.filter;

import work.metanet.client.gateway.constant.OrderedConstant;
import work.metanet.client.gateway.log.CacheServerHttpRequestDecorator;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description 日志过滤器
 *  @author EdisonFeng
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
//@Component
public class LogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        CacheServerHttpRequestDecorator cacheServerHttpRequestDecorator = new CacheServerHttpRequestDecorator(exchange.getRequest());

        return chain.filter(exchange.mutate().request(cacheServerHttpRequestDecorator).build());
    }

    @Override
    public int getOrder() {
        return OrderedConstant.LOGGING_FILTER;
    }
}
