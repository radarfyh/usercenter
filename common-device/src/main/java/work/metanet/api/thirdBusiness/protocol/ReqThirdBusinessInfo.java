package work.metanet.api.thirdBusiness.protocol;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class ReqThirdBusinessInfo implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	private String thirdBusinessId;
    
    @Data
    public static class RespThirdBusinessInfo implements Serializable{
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String thirdBusinessId;
    	private String thirdBusinessName;
    	private String thirdBusinessCode;
        private String remark;
        private String createTime;
        private String updateTime;
    }
    

}
