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
@Table(name = "t_edu_resource")
public class EduResource implements Serializable {
	 /**
     * 资源id
     */
	@Id
    private String resourceId;

    /**
     * 内容名称
     */
    private String resourceTitle;

    /**
     * 简介
     */
    private String introduction;
    
	private String content;

    /**
     * 内容商id
     */
    private String businessId;

    /**
     * 父级id
     */
    private String parentId;

    /**
     * 第三方id
     */
    private String thirdId;

    /**
     * 资源类型
     */
    private String resourceType;

    /**
     * 封面图
     */
    private String coverUrl;

    /**
     * 文件
     */
    private String fileUrl;

    /**
     * 媒体类型
     */
    private String mediaType;
    
    /**
     * 绘本类型
     */
    private String imgbookType;

    /**
     * 适用性别
     */
    private String sex;

    /**
     * 语言
     */
    private String language;

    /**
     * 最小适合年龄
     */
    private Integer minAge;

    /**
     * 最大适用年龄
     */
    private Integer maxAge;
    
    /**
     * 标签-逗号分隔
     */
    private String tags;

    /**
     * 场景-逗号分隔
     */
    private String scenario;

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