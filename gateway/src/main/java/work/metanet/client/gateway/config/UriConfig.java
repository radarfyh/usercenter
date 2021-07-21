
package work.metanet.client.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @Description 网址配置文件
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@ConfigurationProperties
@Data
public class UriConfig {
	HostDesc userHost = new HostDesc("lb://baas-user/",
			"/api/v1/baas-user",
			"baas-user");
	HostDesc visionHost = new HostDesc("lb://baas-vision/",
			"/api/v1/baas-vision",
			"baas-vision");

	public class HostDesc {
		private String hostname;
		private String pathPrefix;
		private String id;
		
		public HostDesc(String hostname, String pathPrefix, String id) {
			this.hostname = hostname;
			this.pathPrefix = pathPrefix;
			this.id = id;
		}

		public String getHostname() {
			return hostname;
		}

		public void setHostname(String hostname) {
			this.hostname = hostname;
		}

		public String getPathPrefix() {
			return pathPrefix;
		}

		public void setPathPrefix(String pathPrefix) {
			this.pathPrefix = pathPrefix;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
