package work.metanet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * t_user_score_detail
 * @author 
 */
@Accessors(chain = true)
@Table(name = "t_user_score_detail")
@Data
public class UserScoreDetail implements Serializable {
    /**
     * 用户积分明细id
     */
	@Id
    private String userScoreDetailId;

    /**
     * 用户积分id
     */
    private String userScoreId;

    /**
     * 交易值
     */
    private BigDecimal changeValue;

    /**
     * 交易后的值
     */
    private BigDecimal afterValue;

    /**
     * 交易类型-EDU:学习/EXCHANGE:兑换
     */
    private String changeType;

    /**
     * 关联业务id
     */
    private String joinId;

    /**
     * 备注-内部使用
     */
    private String remark;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    /**
     * 数据有效性-0无效/1有效(实体类为boolean)
     */
    private Boolean status;

    private static final long serialVersionUID = 1L;
}