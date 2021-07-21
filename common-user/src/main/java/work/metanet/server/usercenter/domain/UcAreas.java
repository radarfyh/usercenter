package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * area区域 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcAreas extends AbstractEntity implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6847602783733103011L;

	private String name;
    
    private String parentId;
    
    private Long acreage;
    
    private Long population;
    
    private Long households;

    private Integer orderNum;
    
    @Transient
    private List<UcAreas> children;
    
    // 非数据库字段
    @Transient
    private String parentName;
    // 非数据库字段
    @Transient
    private Integer level;
 }