package work.metanet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * t_user_score
 * @author 
 */
@Table(name = "t_user_score")
@Accessors(chain = true)
@Data
public class UserScore implements Serializable {
    /**
     * 用户积分id
     */
	@Id
    private String userScoreId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 值
     */
    private BigDecimal value;

    /**
     * 备注-内部使用
     */
    private String remark;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}