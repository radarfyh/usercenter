package work.metanet.api.userScoreDetail.protocol;

import java.io.Serializable;

import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class ReqUserScoreDetailList extends Paging implements Serializable{
	
	private static final long serialVersionUID = -3851499588497776595L;
    private String userScoreId;
    private String changeType;
    private String remark;
    private String startTime;
	private String endTime;
	
	@Data
	public static class RespUserScoreDetailList implements Serializable{
		private static final long serialVersionUID = -5255740365569977577L;
		private String userScoreDetailId;
		private String changeType;
		private Integer changeValue;
		private Integer afterValue;
		private String remark;
		private String createTime;
		private String updateTime;
	}
}
