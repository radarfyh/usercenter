package work.metanet.server.usercenter.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description 抽象实体
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@MappedSuperclass
@Data
@DynamicInsert
@DynamicUpdate
public class AbstractEntity {
	/**
	 * 唯一标识符
	 */
	@Id
	@GenericGenerator(strategy="org.hibernate.id.UUIDGenerator", name = "idGenerator") //这个是hibernate的注解/生成32位UUID
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "idGenerator")
	private String id;
	
	/**
	 * 内部备注
	 */
	private String remark;
	
	/**
	 * 创建人
	 */
	@CreatedBy
	@Column(name = "create_user")
    private String createBy;

	/**
	 * 创建时间
	 */
	@CreatedDate
	@Column(name = "create_time")
    private Date createTime;

	/**
	 * 最后修改人
	 */
	@LastModifiedBy
	@Column(name = "update_user")
    private String lastUpdateBy;

	/**
	 * 最后修改时间
	 */
	@LastModifiedDate
	@Column(name = "update_time")
    private Date lastUpdateTime;

    /**
     * 数据有效性-0无效/1有效(实体类为boolean)
     */
    private Boolean status;
}
