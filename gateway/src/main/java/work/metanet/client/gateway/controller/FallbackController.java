
package work.metanet.client.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.metanet.client.gateway.exception.BaseException;
import work.metanet.client.gateway.response.ResponseResult;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
/**
 * @Description 应急地址
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@RestController
@RequestMapping("/fallback")
@Slf4j
public class FallbackController {
	@RequestMapping("/baas-user")
	public Mono<String> fallbackUser() {
		return Mono.just("fallback for baas-user");
	}
	
	@RequestMapping("/baas-vision")
	public Mono<String> fallbackVision() {
		return Mono.just("fallback for baas-vision");
	}
    @RequestMapping("/defaultfallback")
    public ResponseResult<Object> fallback(){
        log.debug("触发熔断......");
        return ResponseResult.fail(BaseException.DEFAULT_HYSTRIX.build());
    }
}
