package work.metanet.client.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @Description 跨域配置文件，用于测试，应启用GatewaySecrityConfig
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Configuration
public class CorsConfig {
	@Bean
	public CorsWebFilter corsWebFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		// 配置跨域
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.setAllowCredentials(true);

		source.registerCorsConfiguration("/**",corsConfiguration);
		return new CorsWebFilter(source);
	}
}
