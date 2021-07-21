package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 积分详情信息
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcScoreDetail extends AbstractEntity implements Serializable {

    /**
     * 积分id
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
     * 关联业务id, 现解释为appID 2021.06.10
     */
    private String joinId;

    private static final long serialVersionUID = 1L;
}