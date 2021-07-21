package work.metanet.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_subject
 * @author 
 */
@Data
@Table(name = "t_subject")
public class Subject implements Serializable {
	
	@Id
    private Integer subjectId;

    /**
     * 学科名称
     */
    private String subjectName;

    /**
     * 学科拼音
     */
    private String pinyin;

    private static final long serialVersionUID = 1L;
}