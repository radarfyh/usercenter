package work.metanet.api.eyesArticle.protocol;

import work.metanet.base.Paging;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@Data
public class ReqEyesArticleList extends Paging implements Serializable{
	private static final long serialVersionUID = 1L;
    private String eyesArticleTitle;
    private String eyesArticleType;
	private String startTime;
	private String endTime;
	private String remark;
	
	@EqualsAndHashCode(callSuper=true)
	@Data
	public static class RespEyesArticleList extends ReqEyesArticleInfo.RespEyesArticleInfo implements Serializable{
		private static final long serialVersionUID = -5255740365569977577L;
	}
	
}
