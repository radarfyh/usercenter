
package work.metanet.server.usercenter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Description 配置类
 * @author EdisonFeng
 * @DateTime 2021年6月17日
 * Copyright(c) 2021. All Rights Reserved
 */
@ComponentScan(value={"work.metanet.server.usercenter.service"},
	useDefaultFilters = false,
	includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {UserCenterTypeFilter.class})
    })
@Configuration
public class UserCenterConfig {

}
