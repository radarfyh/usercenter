package work.metanet.api.openAppBusinessCdk.protocol;

import java.io.Serializable;

import lombok.Data;

@Data
public class ReqOpenAppBusinessCdkImport implements Serializable{
	
	private static final long serialVersionUID = 478287614852354005L;
	private String cdk;
	private String channelName;
	private String openAppName;
	private String openAppBusinessName;
	private String remark;
	
}
