package work.metanet.client.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableDubbo
public class BaasUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaasUserApplication.class, args);
	}

}
