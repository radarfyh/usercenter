package work.metanet.device;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import tk.mybatis.spring.annotation.MapperScan;

@EnableAsync
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("work.metanet.server.dao")
@ComponentScan(value={"work.metanet.utils",
		"work.metanet.constant",
		"work.metanet.util.sms",
		"work.metanet.util.redis"})
public class DaasDeviceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().web(WebApplicationType.NONE).sources(DaasDeviceApplication.class).run(args);
	 }

}
