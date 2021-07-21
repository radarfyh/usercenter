package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstOrderSendStatus {
	
	NSEND("未发货"),
	YSEND("已发货")
	;
	
	private String text;
	
}
