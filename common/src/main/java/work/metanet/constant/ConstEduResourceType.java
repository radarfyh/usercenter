package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstEduResourceType {
	
	CATEGORY("类目"),
	ALBUM("专辑"),
	RESOURCE("资源"),
	PAGE("资源页")
	;
	
	private String text;
	
}
