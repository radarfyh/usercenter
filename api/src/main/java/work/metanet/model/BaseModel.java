package work.metanet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * basemodel基础模型,继承映射方策略：single Table
 * @author Louis & Edison
 * @date Sep 13, 2018
 */
@MappedSuperclass 
@Data
public class BaseModel {
	
	/**
	 * 唯一标识符
	 */
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
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
