package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_business_app
 * @author 
 */
@Data
@Table(name = "t_business_app")
public class BusinessApp implements Serializable {
    /**
     * 内容商产品id
     */
	@Id
    private String businessAppId;

    /**
     * 内容商id
     */
    private String businessId;

    /**
     * 产品名称
     */
    private String appName;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 版本号
     */
    private String versionCode;
    
    /**
     * 产品地址
     */
    private String appUrl;
    
    /**
     * 产品说明
     */
    private String instruction;

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