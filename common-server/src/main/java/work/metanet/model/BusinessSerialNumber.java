package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * t_business_serial_number
 * @author 
 */
@Accessors(chain = true)
@Data
@Table(name = "t_business_serial_number")
public class BusinessSerialNumber implements Serializable {
    /**
     * 内容商激活码id
     */
	@Id
    private String businessSerialNumberId;

    /**
     * 内容商激活码
     */
    private String businessSnCode;
    
    /**
     * 调用类型
     */
    private String callType;
    
    /**
     * 最大使用次数
     */
    private Integer maxUseNumber;

    /**
     * 使用次数
     */
    private Integer useNumber;
    
    /**
     * 使用状态(NO_USE/SUCCESS/FAIL)
     */
    private String useStatus;

    /**
     * 内容商id
     */
    private String businessId;

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