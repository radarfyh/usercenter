package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * user&role用户角色关系 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcUserRole extends AbstractEntity implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3542009317355776652L;

	private String userId;

    private String roleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}