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
 * t_channel_earnings
 * @author 
 */
@Accessors(chain = true)
@Entity
@Table(name = "t_channel_earnings")
@Data
public class ChannelEarnings implements Serializable {
    /**
     * 渠道收益id
     */
	@Id
    private String channelEarningsId;
	
    /**
     * 渠道id
     */
    private String channelId;

    /**
     * 月份
     */
    private String month;

    /**
     * 订单支付总额
     */
    private BigDecimal orderPayTotalAmount;

    /**
     * 原始收益总额
     */
    private BigDecimal originalEarningsTotalAmount;

    /**
     * 实际收益总额
     */
    private BigDecimal actualEarningsTotalAmount;

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