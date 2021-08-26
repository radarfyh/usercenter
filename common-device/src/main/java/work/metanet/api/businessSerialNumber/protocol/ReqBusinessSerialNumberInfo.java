package work.metanet.api.businessSerialNumber.protocol;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-内容商激活码详情")
@Accessors(chain = true)
@Data
public class ReqBusinessSerialNumberInfo implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	private String businessSerialNumberId;
	
    
    @ApiModel("响应-内容商激活码详情")
    @Accessors(chain = true)
    @Data
    public static class RespBusinessSerialNumberInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	private String businessSerialNumberId;
        private String businessSnCode;
        private String useStatus;
        private String callType;
        private Integer maxUseNumber;
        private Integer useNumber;
        private String businessId;
        private String remark;
        private String createTime;
        private String updateTime;
    	
    }
    

}
