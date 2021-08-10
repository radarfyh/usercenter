package work.metanet.client.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS 跨域配置
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")	// 允许跨域访问的路径
//        .allowedOrigins("*")	// 允许跨域访问的源
//        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")	// 允许请求方法
//        .maxAge(168000)	// 预检间隔时间
//        .allowedHeaders("*")  // 允许头部设置
//        .allowCredentials(true);	// 是否发送cookie
    }
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//配置模板资源路径
		//registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
		//registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
		
		//解决 swagger-ui.html 404报错
//        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        
        // 解决 doc.html 404 报错
//        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
	}
}