package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import work.metanet.server.usercenter.vo.EmailAddress;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 用户地址信息
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcUserAddresses extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 9107380194006660493L;

    /**
     * 用户id
     */
	@Column(name = "user_id")
    private String userId;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 省id
     */
    private String provinceId;

    /**
     * 市id
     */
    private String cityId;

    /**
     * 县id
     */
    private String countyId;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zipCode;
    
    /**
     * 电子邮件地址
     */
	private EmailAddress emailAddress;
    
    /**
     * 传真
     */
    private String fax;

    /**
     * 默认状态
     */
    private Boolean defaultStatus;
}