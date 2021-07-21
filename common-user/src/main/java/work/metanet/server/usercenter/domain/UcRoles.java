package work.metanet.server.usercenter.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * role角色 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcRoles extends AbstractEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3915869374283448978L;

	// 角色代号,例如admin
	private String code;
	
    private String name;
    
    private String parentId;
    
    private String roleType;
}