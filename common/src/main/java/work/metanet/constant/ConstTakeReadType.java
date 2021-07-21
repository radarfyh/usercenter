package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstTakeReadType {
	
	BOOK("课本"),SCENE("场景")
	;
	
	private String text;
	
}
