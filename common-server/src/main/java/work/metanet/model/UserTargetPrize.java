package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * t_user_target_prize
 * @author 
 */
@Table(name = "t_user_target_prize")
@Accessors(chain = true)
@Data
public class UserTargetPrize implements Serializable {
    /**
     * 用户订购id
     */
	@Id
    private String userTargetPrizeId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 商品id
     */
    private String prizeId;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}