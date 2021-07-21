package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_third_business
 * @author 
 */
@Table(name = "t_third_business")
@Data
public class ThirdBusiness implements Serializable {
    /**
     * 第三方内容商id
     */
	@Id
    private String thirdBusinessId;

    /**
     * 第三方内容商名称
     */
    private String thirdBusinessName;

    /**
     * 第三方内容商代码
     */
    private String thirdBusinessCode;

    /**
     * 备注-内部使用
     */
    private String remark;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    /**
     * 创建者id
     */
    private String createUser;

    /**
     * 修改者id
     */
    private String updateUser;

    /**
     * 数据有效性-0无效/1有效(实体类为boolean)
     */
    private Boolean status;

    private static final long serialVersionUID = 1L;
}