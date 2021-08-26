package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import work.metanet.base.domain.AbstractEntity;

/**
 * @Description 用户登录日志
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcUserLogins extends AbstractEntity implements Serializable {
    private String userId;
    private String deviceId;
    private String versionId;
    private static final long serialVersionUID = -5177084382502444761L;
}