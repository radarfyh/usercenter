package work.metanet.api.book.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ReqRemoveBook implements Serializable{
	
	private static final long serialVersionUID = 72288590559616141L;
	
	@NotBlank(message = "课本不能为空")
	private String bookId;

}
