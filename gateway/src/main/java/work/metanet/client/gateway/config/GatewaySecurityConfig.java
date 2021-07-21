package work.metanet.client.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @Description Flux安全配置文件
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Configuration
@EnableWebFluxSecurity
public class GatewaySecurityConfig {
    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity serverHttpSecurity)
            throws Exception {
        serverHttpSecurity
                .csrf().disable()
                .authorizeExchange().pathMatchers("/**").permitAll()
                .anyExchange()
                .authenticated();
        return serverHttpSecurity.build();
    }
}
