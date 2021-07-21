package work.metanet.api.book.protocol;

import java.io.Serializable;

import work.metanet.base.Paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@ApiModel(value = "请求-搜索课本")
@Data
public class ReqSearchBook extends Paging implements Serializable{
	
	private static final long serialVersionUID = 3268439900256673377L;
	@ApiModelProperty("课本id/name")
	private String book;
	@ApiModelProperty("出版社id/name")
	private String press;
	@ApiModelProperty("年级id/name")
	private String grade;
	@ApiModelProperty("科目id/name")
	private String subject;
	
	@Accessors(chain = true)
	@ApiModel(value = "响应-搜索课本")
	@Data
	public static class RespSearchBook implements Serializable{
		
		private static final long serialVersionUID = 1599142936319972793L;
		@ApiModelProperty("课本id")
		private String bookId;
		@ApiModelProperty("课本名称")
		private String bookName;
		/**@ApiModelProperty("出版社id")
		private String pressId;*/
		@ApiModelProperty("出版社名称")
		private String pressName;
		/**@ApiModelProperty("年级id")
		private String gradeId;*/
		@ApiModelProperty("年级名称")
		private String gradeName;
		/**@ApiModelProperty("科目id")
		private String subjectId;*/
		@ApiModelProperty("科目名称")
		private String subjectName;
		@ApiModelProperty("封面")
		private String coverUrl;
		@ApiModelProperty("压缩包")
		private String zipUrl;
		
	}

}
