package work.metanet.client.questionnaire;

import cn.hutool.core.util.URLUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MetanetBaasQuestionnaireApplicationTests {

	@Test
	void contextLoads() {

	    String url = "this is a test";

        System.out.println(URLUtil.getPath(url));
    }

}
