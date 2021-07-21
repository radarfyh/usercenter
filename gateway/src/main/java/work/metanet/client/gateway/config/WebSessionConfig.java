package work.metanet.client.gateway.config;

import work.metanet.client.gateway.resolver.MyCookieWebSessionIdResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseCookie;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.web.server.session.CookieWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

import java.util.function.Consumer;

/**
 * @Description 统一session配置文件，注意不能用@EnableRedisHttpSession，这个不支持WebFlux
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Configuration
@EnableRedisWebSession(maxInactiveIntervalInSeconds = 10*60*60, redisNamespace = "my:spring:session")
public class WebSessionConfig {

    @Bean
    public WebSessionIdResolver webSessionIdResolver() {
        CookieWebSessionIdResolver resolver = new MyCookieWebSessionIdResolver();
        resolver.setCookieName("SESSIONID");

        Consumer<ResponseCookie.ResponseCookieBuilder> consumer = responseCookieBuilder -> {
            responseCookieBuilder.path("/");
        };
        resolver.addCookieInitializer(consumer);
        return resolver;
    }

}
