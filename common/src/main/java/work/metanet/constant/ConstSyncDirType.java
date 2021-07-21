package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstSyncDirType {
	
	BOOK("课本"),ARTICLE("文章"),SCENE("场景")
	;
	
	private String text;
	
}
