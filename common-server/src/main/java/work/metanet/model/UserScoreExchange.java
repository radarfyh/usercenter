package work.metanet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * t_user_score_exchange
 * @author 
 */
@Table(name = "t_user_score_exchange")
@Accessors(chain = true)
@Data
public class UserScoreExchange implements Serializable {
    /**
     * 用户积分兑换id
     */
	@Id
    private String userScoreExchangeId;
	
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
     * 快递单号
     */
    private String courierNumber;

    /**
     * 发货状态-NSEND:未发货/YSEND:已发货
     */
    private String sendStatus;
    
    /**
     * 发货时间
     */
    private Date sendTime;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String county;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zipCode;

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