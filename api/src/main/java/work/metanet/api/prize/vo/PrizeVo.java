package work.metanet.api.prize.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class PrizeVo implements Serializable{
	
	private static final long serialVersionUID = -3560715155570541004L;

	/**
     * 商品id
     */
    private String prizeId;

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
     * 商品状态-ON:上架/OFF:下架
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
	
}
