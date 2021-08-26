package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import work.metanet.base.domain.AbstractEntity;

@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor(staticName = "of")
@Entity
@Data
public class UcPrizes extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 2262205459288645685L;

	/**
     * 渠道id
     */
    private String channelId;

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
     * 库存
     */
    private Integer inventory;

    /**
     * 商品状态-UP:上架/DOWN:下架
     */
    private String prizeStatus;
}
