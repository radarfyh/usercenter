package work.metanet.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_grade
 * @author 
 */
@Data
@Table(name = "t_grade")
public class Grade implements Serializable {
	
	@Id
    private Integer gradeId;

    /**
     * 年级名称
     */
    private String gradeName;

    private static final long serialVersionUID = 1L;
}