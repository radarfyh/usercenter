package work.metanet.api.book.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class ReqSaveBook implements Serializable{
	
	@NotBlank(message = "课本id不能空")
	private String bookId;
	@NotBlank(message = "课本名称不能空")
	private String bookName;
	private String pressId;
	private String subjectId;
	private String gradeId;
	private String volume;
	private String detail;
	@NotBlank(message = "封面不能空")
	private String coverUrl;
	@NotBlank(message = "课本不能空")
	private String zipUrl;
	private String remark;
	
	private static final long serialVersionUID = 4849880606453063048L;

}
