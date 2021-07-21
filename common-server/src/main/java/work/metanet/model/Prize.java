package work.metanet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * t_prize
 * @author 
 */
@Table(name = "t_prize")
@Accessors(chain = true)
@Data
public class Prize implements Serializable {
    /**
     * 奖品id
     */
	@Id
    private String prizeId;

    /**
     * 渠道id
     */
    private String channelId;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 奖品图片
     */
    private String prizeImg;

    /**
     * 积分
     */
    private BigDecimal score;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 奖品状态-UP:上架/DOWN:下架
     */
    private String prizeStatus;

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