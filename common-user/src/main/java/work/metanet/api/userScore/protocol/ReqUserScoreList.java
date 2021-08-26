package work.metanet.api.userScore.protocol;

import java.io.Serializable;

import work.metanet.base.Paging;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class ReqUserScoreList extends Paging implements Serializable{
	
	private static final long serialVersionUID = -3851499588497776595L;
    private String user;
    private String startTime;
	private String endTime;
    private String remark;
    private String appId;
    private String channelId;
	
	@Data
	public static class RespUserScoreList implements Serializable{
		private static final long serialVersionUID = -5255740365569977577L;
		private String userScoreId;
		private String userName;
		private String phone;
		private Integer score;
		private String channelName;
		private String appName;
		private String remark;
		private String createTime;
		private String updateTime;
	}
}
