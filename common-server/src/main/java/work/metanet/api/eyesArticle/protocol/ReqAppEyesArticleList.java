package work.metanet.api.eyesArticle.protocol;

import com.fasterxml.jackson.annotation.JsonFormat;
import work.metanet.base.Paging;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@ApiModel("请求-爱眼软文")
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqAppEyesArticleList extends Paging {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "爱眼类型-ARTICLE:文章/VIDEO:视频",required = true)
	@NotBlank(message = "爱眼类型不能为空")
	private String eyesArticleType;
	
	@ApiModel("响应-爱眼软文")
	@Accessors(chain = true)
	@Data
	public static class RespAppEyesArticleList implements Serializable {
		private static final long serialVersionUID = 1L;
		@ApiModelProperty(value = "软文id")
		private String eyesArticleId;
		@ApiModelProperty(value = "标题")
	    private String eyesArticleTitle;
		@ApiModelProperty(value = "爱眼类型-ARTICLE:文章/VIDEO:视频")
		private String eyesArticleType;
	    @ApiModelProperty(value = "图片")
	    private String eyesArticleImg;
	    @ApiModelProperty(value = "访问地址")
	    private String eyesArticleUrl;
	    @ApiModelProperty(value = "发布时间")
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	    private Date releaseTime;
	    @ApiModelProperty(value = "访问次数")
	    private Integer releaseNumber;
	}

}
