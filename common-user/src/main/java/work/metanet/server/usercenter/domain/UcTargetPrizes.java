package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 用户订购信息
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcTargetPrizes extends AbstractEntity implements Serializable {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 商品id
     */
    private String prizeId;


    private static final long serialVersionUID = 1L;
}