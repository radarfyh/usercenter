package work.metanet.client.user.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import work.metanet.config.Swagger2Config;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Profile({"dev", "test"})//设置 dev test 环境开启 prod 环境就关闭了
@Slf4j
public class SwaggerConfig extends Swagger2Config {

	@Override
	public Docket createRestApi() {
		log.debug("createRestApi >>>");
		return super.createRestApi();
	}
	
}