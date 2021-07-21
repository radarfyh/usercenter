package work.metanet.api.book.protocol;

import java.io.Serializable;

import work.metanet.api.book.protocol.ReqBookInfo.RespBookInfo;
import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqBookList extends Paging implements Serializable{
	
	private static final long serialVersionUID = 3397901518385598200L;
	
	private String book;
	private String pressId;
	private String gradeId;
	private String subjectId;
	private String startTime;
	private String endTime;
	private String remark;
    
	@EqualsAndHashCode(callSuper=true)
    @Accessors(chain = true)
    @Data
    public static class RespBookList extends RespBookInfo implements Serializable{
    	
    	private static final long serialVersionUID = -4291721599975198242L;
    	
    	
    	
    }
    

}
