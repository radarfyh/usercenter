package work.metanet.server.usercenter.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * area&department区域部门关系 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcAreaDept extends AbstractEntity implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9114676215199829805L;

	private String areaId;

    private String deptId;


}