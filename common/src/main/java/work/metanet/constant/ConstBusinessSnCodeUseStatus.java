package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstBusinessSnCodeUseStatus {
	
	NO_USE("未使用"),
	USEING("使用中"),
	SUCCESS("成功"),
	FAIL("失败")
	;
	
	private String text;
	
}
