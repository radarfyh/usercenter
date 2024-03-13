package work.metanet.questionnaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

//import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {"work.metanet","work.metanet.questionnaire"})
@EnableAsync
@EnableDiscoveryClient
@MapperScan("work.metanet.questionnaire.dao")
//@EnableAutoDataSourceProxy
public class DaasQuestionnaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaasQuestionnaireApplication.class, args);
	}

}
