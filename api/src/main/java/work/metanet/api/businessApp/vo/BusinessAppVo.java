package work.metanet.api.businessApp.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("内容商产品信息")
@Data
public class BusinessAppVo implements Serializable{
	
	private static final long serialVersionUID = -746601417733365788L;
	
	@ApiModelProperty(value = "包名")
	private String packageName;
	
	@ApiModelProperty(value = "版本")
	private String versionCode;
	
	@ApiModelProperty(value = "url")
	private String url;
	
	@ApiModelProperty(value = "更新说明")
	private String instruction;
	
}
