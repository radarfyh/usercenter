package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 收藏信息
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcUserScores extends AbstractEntity implements Serializable {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 值
     */
    private BigDecimal value;

    private static final long serialVersionUID = 1L;
}