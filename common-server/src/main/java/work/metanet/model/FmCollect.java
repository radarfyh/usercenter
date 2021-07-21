package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * t_fm_collect
 * @author 
 */
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@Data
@Table(name = "t_fm_collect")
public class FmCollect implements Serializable {
    /**
     * 收藏id
     */
	@Id
    private String fmCollectId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}