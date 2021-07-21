package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * t_fm_reward
 * @author 
 */
@Accessors(chain = true)
@Data
@Table(name = "t_fm_reward")
public class FmReward implements Serializable {
    /**
     * 奖励id
     */
	@Id
    private String fmRewardId;

    /**
     * 用户id
     */
    private String userId;
    
    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 奖励数量
     */
    private Integer rewardNumber;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}