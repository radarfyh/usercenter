package work.metanet.api.businessSerialNumber.protocol;

import java.io.Serializable;

import lombok.Data;

@Data
public class ReqImportBusinessSerialNumber implements Serializable{
	
	private static final long serialVersionUID = 478287614852354005L;
	private String businessCode;
	private String businessSnCode;
	private String callType;
	private Integer maxUseNumber;
	private String remark;
	
}
