package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * t_fm_diary
 * @author 
 */
@Accessors(chain = true)
@Data
@Table(name = "t_fm_diary")
public class FmDiary implements Serializable {
    /**
     * 日记id
     */
	@Id
    private String fmDiaryId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    /**
     * 数据有效性-0无效/1有效(实体类为boolean)
     */
    private Boolean status;

    /**
     * 内容
     */
    private String content;

    private static final long serialVersionUID = 1L;
}