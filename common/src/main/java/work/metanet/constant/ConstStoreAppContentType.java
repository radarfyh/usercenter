package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstStoreAppContentType {

	EDU("学习"),
	AMUSEMENT("娱乐")
	;
	
	private String text;
	
	
}
