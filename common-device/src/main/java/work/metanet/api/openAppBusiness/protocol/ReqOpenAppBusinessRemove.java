package work.metanet.api.openAppBusiness.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ReqOpenAppBusinessRemove implements Serializable{
	
	private static final long serialVersionUID = 1055722802402768004L;

	@NotBlank
	private String openAppBusinessId;
	
}
