package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_business_content
 * @author 
 */
@Data
@Table(name = "t_business_content")
public class BusinessContent implements Serializable {
	
	 /**
     * 内容商内容id
     */
	@Id
    private String businessContentId;

    /**
     * 内容名称
     */
    private String contentName;

    /**
     * 内容商id
     */
    private String businessId;

    /**
     * 父级id
     */
    private String parentId;

    /**
     * 所属阶段
     */
    private String phase;

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