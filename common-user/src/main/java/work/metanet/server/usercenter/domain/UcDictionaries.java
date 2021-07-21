package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * dictionary数据字典 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcDictionaries extends AbstractEntity implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7658011302050247938L;

	private String value;

    private String label;

    private String type;

    private String description;

    private Long sort;

}