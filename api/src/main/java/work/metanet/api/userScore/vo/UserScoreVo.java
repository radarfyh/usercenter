package work.metanet.api.userScore.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class UserScoreVo implements Serializable{
	
	private static final long serialVersionUID = -480592082829951977L;
	private String userScoreId;
    private String userId;
    private BigDecimal value;

}
