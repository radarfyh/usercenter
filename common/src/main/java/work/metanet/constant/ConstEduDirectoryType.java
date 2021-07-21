package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstEduDirectoryType {
	
	CATEGORY("类目"),
	THEME("主题"),
	ABILITY("能力")
	;
	
	private String text;
	
}
