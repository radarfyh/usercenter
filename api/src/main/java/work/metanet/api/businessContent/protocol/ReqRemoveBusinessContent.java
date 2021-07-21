package work.metanet.api.businessContent.protocol;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReqRemoveBusinessContent implements Serializable{
	
	private static final long serialVersionUID = -8542855042034048825L;
	private String businessContentId;
	
}
