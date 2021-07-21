package work.metanet.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "t_edu_timetable_resource")
public class EduTimetableResource implements Serializable{
	
	private static final long serialVersionUID = -5343775074493609674L;
	
	@Id
	private String timetableResourceId;
	
	private String timetableId;
	
	private String resourceId;
	
}
