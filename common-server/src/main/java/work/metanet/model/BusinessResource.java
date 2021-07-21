package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_business_resource
 * @author 
 */
@Data
@Table(name = "t_business_resource")
public class BusinessResource implements Serializable {
    /**
     * 内容商资源id
     */
	@Id
    private String businessResourceId;

    /**
     * 第三方资源id
     */
    private String thirdResourceId;

    /**
     * 内容商代码
     */
    private String businessCode;

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