package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstBusinessSnCallType {
	
	SDK,//一个key对应多台设备
	APK;//一个key对应一台设备
	
}
