package work.metanet.client.gateway.filter;

import work.metanet.client.gateway.constant.HeaderConstant;
import work.metanet.client.gateway.constant.OrderedConstant;
import work.metanet.client.gateway.log.Log;
import work.metanet.client.gateway.log.LogHelper;
import work.metanet.client.gateway.transform.MessageTransformFactory;
import work.metanet.client.gateway.utils.GenerateIdUtils;
import work.metanet.client.gateway.utils.IpUtils;
import io.netty.buffer.UnpooledByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.server.HandlerStrategies;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import javax.annotation.Resource;

/**
 * @Description 打印请求日志
 *  @author EdisonFeng
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
@Component
@Slf4j
public class RequestLogFilter implements GlobalFilter, Ordered {
    @Resource
    private MessageTransformFactory messageTransformFactory;

    @Override
    public int getOrder() {
        return OrderedConstant.REQUEST_FILTER;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        long startTime = System.currentTimeMillis();
        try {
            ServerHttpRequest request = exchange.getRequest();
            // 设置X-Request-Id
            AtomicReference<String> requestId = new AtomicReference<>(GenerateIdUtils.requestIdWithUUID());
            Consumer<HttpHeaders> httpHeadersConsumer = httpHeaders -> {
                String headerRequestId = request.getHeaders().getFirst(HeaderConstant.REQUEST_ID);
                if (StringUtils.isBlank(headerRequestId)) {
                    httpHeaders.set(HeaderConstant.REQUEST_ID, requestId.get());
                } else {
                    requestId.set(headerRequestId);
                }
                httpHeaders.set(HeaderConstant.START_TIME_KEY, String.valueOf(startTime));
//                httpHeaders.set(HeaderConstant.ALLOW_ORIGIN, String.valueOf("*"));
            };
            ServerRequest serverRequest = ServerRequest.create(exchange,
                    HandlerStrategies.withDefaults().messageReaders());
            URI requestUri = request.getURI();
            String uriQuery = requestUri.getQuery();
            String url = requestUri.getPath() + (StringUtils.isNotBlank(uriQuery) ? "?" + uriQuery : "");
            HttpHeaders headers = request.getHeaders();
            MediaType mediaType = headers.getContentType();
            String method = request.getMethodValue().toUpperCase();

            // 原始请求体
            final AtomicReference<String> requestBody = new AtomicReference<>();
            final AtomicBoolean newBody = new AtomicBoolean(false);
            if (Objects.nonNull(mediaType) && LogHelper.isUploadFile(mediaType)) {
                requestBody.set("上传文件");
            } else {
                if (method.equals("GET")) {
                    if (StringUtils.isNotBlank(uriQuery)) {
                        requestBody.set(uriQuery);
                    }
                } else {
                    newBody.set(true);
                }
            }
            final Log logDTO = new Log();
            logDTO.setLevel(Log.LEVEL.INFO);
            logDTO.setRequestUrl(url);
            logDTO.setRequestBody(requestBody.get());
            logDTO.setRequestMethod(method);
            logDTO.setRequestId(requestId.get());
            logDTO.setIp(IpUtils.getClientIp(request));

            ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().headers(httpHeadersConsumer).build();
            ServerWebExchange build = exchange.mutate().request(serverHttpRequest).build();
            return build.getSession().flatMap(webSession -> {
                logDTO.setSessionId(webSession.getId());
                if (newBody.get() && headers.getContentLength() > 0) {
                    Mono<String> bodyToMono = serverRequest.bodyToMono(String.class);
                    return bodyToMono.flatMap(reqBody -> {
                        logDTO.setRequestBody(reqBody);
                        // 重写原始请求
                        ServerHttpRequestDecorator requestDecorator = new ServerHttpRequestDecorator(exchange.getRequest()) {
                            @Override
                            public Flux<DataBuffer> getBody() {
                                NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(new UnpooledByteBufAllocator(false));
                                DataBuffer bodyDataBuffer = nettyDataBufferFactory.wrap(reqBody.getBytes());
                                
                                //转换请求参数格式
                                byte[] content = new byte[bodyDataBuffer.readableByteCount()];
                                bodyDataBuffer.read(content);
                                DataBufferUtils.release(bodyDataBuffer);

                                Charset charset = LogHelper.getMediaTypeCharset(mediaType);
                                String requestBody = new String(reqBody.getBytes(), charset);
                                
                                AtomicReference<String> newRequestBody = new AtomicReference<>(requestBody);
                                
                                Log.TYPE logType = Log.TYPE.REQUEST;
                                
                                log.info("ServerHttpRequestDecorator --> url:{},originalContent:{}", url, requestBody);
                                
                                // 报文结构转换函数调用
                                content = messageTransformFactory.compareAndTransform(logType, url, 
                                		requestBody, content, charset, newRequestBody);
                                
                                requestBody = newRequestBody.get();
                                
                                DataBuffer newDataBuffer = nettyDataBufferFactory.wrap(content);
                                
                                return Flux.just(newDataBuffer);
                            }
                        };
                        return chain.filter(exchange.mutate()
                                .request(requestDecorator)
                                .build()).then(LogHelper.doRecord(logDTO));
                    });
                } else {
                    return chain.filter(exchange).then(LogHelper.doRecord(logDTO));
                }
            });

        } catch (Exception e) {
            log.error("请求日志打印出现异常", e);
            return chain.filter(exchange);
        }
    }
}
