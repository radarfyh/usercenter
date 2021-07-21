package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "t_edu_timetable")
public class EduTimetable implements Serializable{
	
	private static final long serialVersionUID = -5343775074493609674L;
	
	@Id
	private String timetableId;
	
	private Integer age;
	
	private Date startDate;
	
	private Date endDate;
	
	private String content;
	
}
