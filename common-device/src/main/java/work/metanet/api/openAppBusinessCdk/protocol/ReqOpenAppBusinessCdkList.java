package work.metanet.api.openAppBusinessCdk.protocol;

import java.io.Serializable;

import work.metanet.base.Paging;
import work.metanet.model.OpenAppBusinessCdk;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@ApiModel("请求-开放平台应用业务cdk列表")
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqOpenAppBusinessCdkList extends Paging implements Serializable{
	private static final long serialVersionUID = 1L;
	private String channelId;
	private String appId;
	private String openAppBusinessId;
	private Boolean useStatus;
	private String cdk;
	private String deviceId;
	private String remark;
	private String startTime;
	private String endTime;
	
	@ApiModel("响应-开放平台应用业务cdk列表")
	@EqualsAndHashCode(callSuper=true)
	@Accessors(chain = true)
	@Data
	public static class RespOpenAppBusinessCdkList extends OpenAppBusinessCdk implements Serializable {
		private static final long serialVersionUID = 1L;
		private String deviceId;
		private String appName;
		private String channelName;
		private String businessName;
	}

}
