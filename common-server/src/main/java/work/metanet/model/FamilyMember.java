package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_family_member
 * @author 
 */
@Data
@Table(name = "t_family_member")
public class FamilyMember implements Serializable {
    /**
     * 家庭成员id
     */
	@Id
    private String familyMemberId;
	
	/**
	 * 是否有管理权限-0否/1是
	 */
	private Boolean isManager;
	
	/**
	 * 是否人脸识别-0否/1是
	 */
	private Boolean isFace;

    /**
     * 关系名称
     */
    private String relationName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String headUrl;

    /**
     * 性别-0女/1男
     */
    private String gender;
    
    private Date birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 学历-0幼儿园/1小学
     */
    private String education;

    /**
     * 年级-1/2/3/4/5/6/7/8/9
     */
    private String grade;

    /**
     * 关联用户id
     */
    private String joinUserId;
    
    /**
     * 奖励数量
     */
    private String rewardNumber;

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