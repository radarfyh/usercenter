package work.metanet.api.user.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import work.metanet.server.usercenter.domain.UcUsers;

@EqualsAndHashCode(callSuper=true)
@Data
public class UserVo extends UcUsers {
	
	private static final long serialVersionUID = -5983277593847087041L;

}
