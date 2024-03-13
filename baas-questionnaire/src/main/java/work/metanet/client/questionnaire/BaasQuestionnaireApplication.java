package work.metanet.client.questionnaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class BaasQuestionnaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaasQuestionnaireApplication.class, args);
	}

}
