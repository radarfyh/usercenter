package work.metanet.api.businessApp.protocol;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class ReqSaveBusinessApp implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	private String businessAppId;
	private String businessId;
	private String appName;
	private String packageName;
	private String versionCode;
	private String appUrl;
	private String remark;
	private String instruction;

}
