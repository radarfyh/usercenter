package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import work.metanet.base.domain.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * user用户 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcUsers extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 5195998892769899487L;
	
    /**
     * 地址
     */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Set<UcUserAddresses> addresses = new HashSet<UcUserAddresses>();
    /**
     * 产品ID
     */
	private String appId;
    
    /**
     * 岗位/类型
     */
    private String userType;
    
    
    /**
     * 账号
     */
	private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;
    
    /**
     * 昵称
     */
    private String nickName;
    
    /**
     * 生日
     */
    private Date birthday;
    
    /**
     * 性别-0女/1男/2保密
     */
    private String gender;
    
    /**
     * 电话
     */
    private String phone;
    
    /**
     * 电子邮件地址
     */
	@Column(unique = true)
//	private EmailAddress email; 
	private String email; 
	
    /**
     * 年龄
     */
    private Double age;
    
    /**
     * 爱好
     */
    private String hobby;
    
    /**
     * 头像地址
     */
    private String headUrl;
    
    /**
     * 账号
     */
    private String postcode;

    /**
     * 启用状态-0禁用/1启用
     */
    private Boolean enableStatus;

    /**
     * 部门ID
     */
    @Transient
    private String deptId;

    /**
     * 部门名称
     */
    @Transient
    private String deptName;
    
    /**
     * 角色名称
     */
    @Transient
    private String roleNames;
    
    /**
     * 用户角色
     */
    //@OneToMany(fetch=FetchType.LAZY)  
    //@JoinColumn(name="id") 
    @Transient
    private List<UcUserRole> userRoles = new ArrayList<>();
    
    /**
     * 用户部门
     */
    //@OneToMany(fetch=FetchType.LAZY)  
    //@JoinColumn(name="id") 
    @Transient
    private List<UcUserDept> userDepts = new ArrayList<>();
    
    /**
     * 角色
     */
    //@OneToMany(fetch=FetchType.LAZY)  
    //@JoinColumn(name="roleId") 
    @Transient
    private List<UcRoles> roles = new ArrayList<>();
    
    /**
     * 部门
     */
    //@OneToMany(fetch=FetchType.LAZY)  
    //@JoinColumn(name="deptId") 
    @Transient
    private List<UcDepartments> departments = new ArrayList<>();

}