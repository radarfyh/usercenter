package work.metanet.api.thirdBusiness.protocol;

import java.io.Serializable;

import work.metanet.api.thirdBusiness.protocol.ReqThirdBusinessInfo.RespThirdBusinessInfo;
import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqThirdBusinessList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	@EqualsAndHashCode(callSuper=true)
    @Accessors(chain = true)
    @Data
    public static class RespThirdBusinessList extends RespThirdBusinessInfo implements Serializable{
    	private static final long serialVersionUID = -4291721599975198242L;
    }
	
}
