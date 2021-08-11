package work.metanet.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

import work.metanet.exception.ResultResponseEnum;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Profile({"dev", "test"})//设置 dev test 环境开启 prod 环境就关闭了
public class Swagger2Config {
	
	@Value("${spring.application.name:}")
    private String appName;
	//定义分隔符,配置Swagger多包
    private static final String splitor = ";";
	
	
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		//.globalOperationParameters(getParameterList())
        		.globalResponseMessage(RequestMethod.POST, getResponseMessageList())
                .apiInfo(apiInfo())
                .groupName("APP")
                .select()
                //所有的接口都通过swagger管理RequestHandlerSelectors.any()
                //指定包下RequestHandlerSelectors.basePackage("work.metanet.controller")
                //带注解RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)
                //多包
                //.apis(basePackage("work.metanet.controller;work.metanet.base"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
    
	private List<ResponseMessage> getResponseMessageList(){
		List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
        for (ResultResponseEnum resultMessage : ResultResponseEnum.values()) {
        	responseMessages.add(new ResponseMessageBuilder().code(resultMessage.getResponseCode()).message(resultMessage.getMessage()).build());
		}
        return responseMessages;
	}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title(appName.toUpperCase() + " RESTful APIs")
                .description("全局header【 appId | packageName | versionCode | timestamp | nonce | cid | deviceId | Authorization | sign 】")
                //服务条款
                .termsOfServiceUrl("/api")
                .contact(new Contact("edison","","radarfyh@hotmail.com"))
                .version("1.0")
                .build();
    }
    
	 /**
	 * @Description: 重写basePackage方法使其能够实现多包访问
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/27
	 */
	@SuppressWarnings("unused")
	private static Predicate<RequestHandler> basePackage(final String basePackage) {
	     return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
	}
	
	private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
	     return input -> {
	         // 循环判断匹配
	         for (String strPackage : basePackage.split(splitor)) {
	             boolean isMatch = input.getPackage().getName().startsWith(strPackage);
	             if (isMatch) {
	                 return true;
	             }
	         }
	         return false;
	     };
	 }
	
	 @SuppressWarnings("deprecation")
	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
	     return Optional.fromNullable(input.declaringClass());
	 }
    
    
}