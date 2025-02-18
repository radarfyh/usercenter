package work.metanet.client.user.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import work.metanet.client.user.security.JwtAuthenticationFilter;
import work.metanet.client.user.security.JwtAuthenticationProvider;

/**
 * Spring Security Config
 * 
 * @author Louis & Edison
 * @date Nov 20, 2018
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 使用自定义身份验证组件
		auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
		http.cors().and().csrf().disable().authorizeRequests()
				// 跨域预检请求
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				// 首页
				.antMatchers("/").permitAll()
				// web jars
				.antMatchers("/webjars/**").permitAll()
				// 查看SQL监控（druid）
				.antMatchers("/druid/**").permitAll()
				// 登录页面
				.antMatchers("/login").permitAll()
				// swagger
				.antMatchers("/swagger-ui.html").permitAll().antMatchers("/doc.html").permitAll()
				.antMatchers("/swagger-resources").permitAll().antMatchers("/v2/api-docs").permitAll()
				.antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
				// 验证码
				.antMatchers("/captcha.jpg**").permitAll()
				// 服务监控
				.antMatchers("/actuator/**").permitAll()
				// 其他所有请求需要身份认证
				.anyRequest().authenticated();
		// 退出登录处理器
		http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
		// token验证过滤器
		http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()),
				UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	/**
	 * CORS配置，也可使用addCorsMappings或者CorsFilter，参考https://segmentfault.com/a/1190000019485883
	 * @return
	 */
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedHeaders(
				Arrays.asList("token", "Content-Type", "nonce", "timestamp", "Authorization", "sign"));
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "OPTIONS", "DELETE"));
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8092"));
		configuration.setAllowCredentials(true); // 必须
		configuration.setMaxAge((long)168000);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}
}