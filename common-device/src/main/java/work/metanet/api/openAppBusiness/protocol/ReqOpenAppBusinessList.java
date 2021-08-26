package work.metanet.api.openAppBusiness.protocol;

import java.io.Serializable;

import work.metanet.base.Paging;
import work.metanet.model.OpenAppBusiness;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@ApiModel("请求-开放平台应用业务列表")
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqOpenAppBusinessList extends Paging implements Serializable{
	private static final long serialVersionUID = 1L;
	private String channelId;
	private String appId;
	private String businessName;
	private String businessCode;
	private String remark;
	private String startTime;
	private String endTime;
	
	@ApiModel("响应-开放平台应用业务列表")
	@EqualsAndHashCode(callSuper=true)
	@Accessors(chain = true)
	@Data
	public static class RespOpenAppBusinessList extends OpenAppBusiness implements Serializable {
		private static final long serialVersionUID = 1L;
		private String appName;
		private String channelName;
	}

}
