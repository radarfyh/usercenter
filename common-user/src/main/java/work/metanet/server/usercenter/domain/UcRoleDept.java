package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * role&department角色部门关系 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcRoleDept extends AbstractEntity implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5349428019898493600L;

	private String roleId;

    private String deptId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}