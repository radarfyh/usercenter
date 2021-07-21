package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * t_fm_browse
 * @author 
 */
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@Data
@Table(name = "t_fm_browse")
public class FmBrowse implements Serializable {
    /**
     * 浏览id
     */
	@Id
    private String fmBrowseId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 播放占比%
     */
    private Double ratio;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}