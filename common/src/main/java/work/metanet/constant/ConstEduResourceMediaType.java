package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstEduResourceMediaType {
	
	AUDIO("音频"),
	VIDEO("视频"),
	IMGBOOK("绘本")
	;
	
	private String text;
	
}
