package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import work.metanet.base.domain.AbstractEntity;

/**
 * log日志 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcLogs extends AbstractEntity implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -835550612752615256L;

	private String userName;

    private String operation;

    private String method;

    private String params;

    @Column(name="execute_time")
    private Long time;

    private String ip;

}