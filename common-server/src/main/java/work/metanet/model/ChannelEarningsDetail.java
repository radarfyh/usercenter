package work.metanet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * t_channel_earnings_detail
 * @author 
 */
@Accessors(chain = true)
@Entity
@Table(name = "t_channel_earnings_detail")
@Data
public class ChannelEarningsDetail implements Serializable {
    /**
     * 渠道收益明细id
     */
	@Id
    private String channelEarningsDetailId;

    /**
     * 渠道收益id
     */
    private String channelEarningsId;
    
    /**
     * 第三方内容商id
     */
    private String thirdBusinessId;

    /**
     * 用户id
     */
    private String userId;
    
    private String orderNumber;

    /**
     * 订单支付时间
     */
    private Date orderPayTime;

    /**
     * 订单支付金额
     */
    private BigDecimal orderPayAmount;

    /**
     * 原始收益金额
     */
    private BigDecimal originalEarningsAmount;

    /**
     * 结算比率
     */
    private Double settlementRatio;

    /**
     * 实际收益金额
     */
    private BigDecimal actualEarningsAmount;

    /**
     * 备注-内部使用
     */
    private String remark;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    /**
     * 创建者id
     */
    private String createUser;

    /**
     * 修改者id
     */
    private String updateUser;

    /**
     * 数据有效性-0无效/1有效(实体类为boolean)
     */
    private Boolean status;

    private static final long serialVersionUID = 1L;
}