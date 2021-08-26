package work.metanet.api.book.protocol;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class ReqBookInfo implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	private String bookId;
    
    @Accessors(chain = true)
    @Data
    public static class RespBookInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	
    	private String bookId;
    	private String bookName;
    	private String subjectId;
    	private String subjectName;
    	private String pressId;
    	private String pressName;
    	private String gradeId;
    	private String gradeName;
    	private String volume;
    	private String detail;
    	private String coverUrl;
    	private String zipUrl;
    	private String remark;
    	private String createTime;
    	private String updateTime;
    }
    

}
