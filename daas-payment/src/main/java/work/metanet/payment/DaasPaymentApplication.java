package work.metanet.payment;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value={"work.metanet.utils",
		"work.metanet.constant",
		"work.metanet.util.sms",
		"work.metanet.util.redis"})
@EnableJpaRepositories(basePackages={"work.metanet.payment.repository"})
@EntityScan(basePackages = {"work.metanet.model","work.metanet.api.user.model"})
public class DaasPaymentApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().web(WebApplicationType.NONE).sources(DaasPaymentApplication.class).run(args);
	}

}
