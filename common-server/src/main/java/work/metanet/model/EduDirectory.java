package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import lombok.Data;

@Table(name = "t_edu_directory")
@Data
public class EduDirectory implements Serializable{
	
	private static final long serialVersionUID = -949335327425534338L;
	
	private String directoryId;
	/**
	 * 目录类型-CATEGORY/ALBUM/THEME/ABILITY
	 */
	private String directoryType;
	
	private String directoryName;
	
	private String introduction;
	
	private String coverUrl;
	
	private String parentId;
	
	private Integer sort;

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

}
