package work.metanet.server.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value={"work.metanet.utils",
		"work.metanet.constant",
		"work.metanet.util.sms",
		"work.metanet.util.redis"})
//@EnableJpaRepositories(basePackages={"work.metanet.server.usercenter.repository"})
//@EntityScan(basePackages = {"work.metanet.model","work.metanet.api.user.model"})
public class DaasUsercenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaasUsercenterApplication.class, args);
	}

}
