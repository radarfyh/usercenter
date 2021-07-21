package work.metanet.api.storeApp.protocol;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@ApiModel("请求-应用商店搜索")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=true)
@Data
public class ReqSearchStoreApp extends Paging implements Serializable{

	private static final long serialVersionUID = 5448598344020657643L;
	
	@ApiModelProperty(value = "搜索关键字")
	private String searchKey;
	
	@ApiModelProperty(value = "阶段标签-0:幼儿/1:小学/2:中学/3:高中/100:综合/101:推荐", required = true)
	@Pattern(regexp = "^(0|1|2|3|100|101)$", message = "阶段标签格式错误")
	private String phaseTag;
	
	@ApiModelProperty(value = "内容类型-EDU:学习/AMUSEMENT:娱乐")
	@Pattern(regexp = "^(|EDU|AMUSEMENT)$", message = "内容类型格式错误")
	private String contentType;
	
	@JsonIgnore
	private String packageName;
	
	@JsonIgnore
	private String channelId;
	
	@ApiModel("响应-应用商店搜索")
	@Data
	public static class RespSearchStoreApp implements Serializable{
		
		private static final long serialVersionUID = -4963307395308034601L;
		@ApiModelProperty(value = "包名")
		private String packageName;
		@ApiModelProperty(value = "调用类名")
		private String callClass;
		@ApiModelProperty(value = "应用名称")
		private String appName;
		@ApiModelProperty(value = "文件地址")
		private String url;
		@ApiModelProperty(value = "应用图标")
		private String icon;
		@ApiModelProperty(value = "版本名")
		private String versionName;
		@ApiModelProperty(value = "版本号")
		private String versionCode;
		@ApiModelProperty(value = "md5")
		private String md5;
		@ApiModelProperty(value = "文件大小(mb)")
		private BigDecimal fileSize;
		
		
	}

}
