package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_book
 * @author 
 */
@Data
@Table(name = "t_book")
public class Book implements Serializable {
	
	@Id
    private String bookId;

    /**
     * 课本名称
     */
    private String bookName;

    /**
     * 学科id
     */
    private Integer subjectId;

    /**
     * 出版社id
     */
    private Integer pressId;

    /**
     * 年级id
     */
    private Integer gradeId;
    
    /**
     * 册数
     */
    private String volume;

    /**
     * 内容介绍
     */
    private String detail;

    /**
     * 封面地址
     */
    private String coverUrl;

    /**
     * 压缩文件地址
     */
    private String zipUrl;

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