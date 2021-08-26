package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import work.metanet.base.domain.AbstractEntity;

/**
 * @Description 积分交易信息
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcScoreExchanges extends AbstractEntity implements Serializable {

	/**
	 * 订单号
	 */
	private String orderNumber;
	
	private String channelId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 商品id
     */
    private String prizeId;

    /**
     * 商品名称
     */
    private String prizeName;

    /**
     * 商品图片
     */
    private String prizeImg;

    /**
     * 积分
     */
    private BigDecimal score;
    
    /**
     * 物流id
     */
    private String logisticsId;

    private static final long serialVersionUID = 1L;
}