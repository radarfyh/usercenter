package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstUserScoreChangeType {

	EDU("学习"),
	EXCHANGE("兑换");
	
	private String text;
	
}
