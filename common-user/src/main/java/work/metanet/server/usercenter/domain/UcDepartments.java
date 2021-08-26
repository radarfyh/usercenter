package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import work.metanet.base.domain.AbstractEntity;

/**
 * department部门 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcDepartments extends AbstractEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7247769408574460636L;

	private String code;

	private String name;
    
    private String parentId;
    
    private String departmentType;
    
    private String principal;
    
    private String departmentLevel;
    private String address;
    private String telephone;
    private String fax;
    private String postcode;

    private Integer orderNum;

    
    //@OneToMany(fetch=FetchType.LAZY)  
    //@JoinColumn(name="id") 
    // 非数据库字段
    @Transient
    private List<UcDepartments> children;
    
    // 非数据库字段
    @Transient
    private String parentName;
    // 非数据库字段
    @Transient
    private Integer level;
    
}