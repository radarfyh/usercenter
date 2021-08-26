package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import work.metanet.base.domain.AbstractEntity;

/**
 * @Description 家庭成员信息
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcFamilyMembers extends AbstractEntity implements Serializable {

    /**
     * 成员id，关联users表
     */
    private String userId;

    /**
     * 家主id，关联users表
     */
    private String masterId;
    
    /**
     * 关系名称
     */
    private String relationName;

    /**
     * 学历-0幼儿园/1小学
     */
    private String education;

    /**
     * 年级-1/2/3/4/5/6/7/8/9
     */
    private String grade;

    private static final long serialVersionUID = 1L;
}