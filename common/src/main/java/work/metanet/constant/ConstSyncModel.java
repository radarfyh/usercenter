package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstSyncModel {
	
	LEARN_DIR("work.metanet.model.mongo.LearnDir"),
	TAKE_READ("work.metanet.model.mongo.TakeRead"),
	TAKE_READ_DETAIL("work.metanet.model.mongo.TakeReadDetail")
	;
	
	private String className;
	
}
