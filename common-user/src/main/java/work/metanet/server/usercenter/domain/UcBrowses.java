package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description 浏览信息
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor(staticName = "of")
@Entity
@Data
public class UcBrowses extends AbstractEntity implements Serializable {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 内容id
     */
    private String contentId;
    
    /**
     * 播放占比%
     */
    private Double ratio;

    private static final long serialVersionUID = 1L;
}