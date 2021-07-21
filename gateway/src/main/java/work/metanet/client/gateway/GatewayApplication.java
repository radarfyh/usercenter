package work.metanet.client.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import work.metanet.client.gateway.config.UriConfig;

/**
 * @Description 启动类
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@SpringBootApplication
//@EnableConfigurationProperties(UriConfig.class)
public class GatewayApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GatewayApplication.class, args);

        SpringApplication application = new SpringApplication(GatewayApplication.class);
        // 该设置方式
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);

	}
	
//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfig uri) {
//		return builder.routes()
//                .route(p -> p
//                		.path(uri.getUserHost().getPathPrefix() + "**")
//                        .filters(f -> f.rewritePath(uri.getUserHost().getPathPrefix() + "(?<seg>/?.*)", "/${seg}")
//                                .addRequestHeader("X-" + uri.getUserHost().getId() + "-Header", 
//                                		uri.getUserHost().getId() + "-header")
//                                .hystrix(c -> c.setName("hystrix")
//                                        .setFallbackUri("forward:/fallback/" + uri.getUserHost().getId())))
//                        .uri(uri.getUserHost().getHostname())
//                        .id(uri.getUserHost().getId()))
//
//                .route(p -> p
//                		.path(uri.getVisionHost().getPathPrefix() + "**")
//                        .filters(f -> f.rewritePath(uri.getVisionHost().getPathPrefix() + "(?<seg>/?.*)", "/${seg}")
//                                .addRequestHeader("X-" + uri.getVisionHost().getId() + "-Header", 
//                                		uri.getVisionHost().getId() + "-header")
//                                .hystrix(c -> c.setName("hystrix")
//                                        .setFallbackUri("forward:/fallback/" + uri.getVisionHost().getId())))
//                        .uri(uri.getVisionHost().getHostname())
//                        .id(uri.getVisionHost().getId()))
//                
//                .build();
//	}
}
