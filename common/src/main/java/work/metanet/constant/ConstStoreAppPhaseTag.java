package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstStoreAppPhaseTag {

	_0("幼儿"),
	_1("小学"),
	_2("中学"),
	_3("高中"),
	_100("综合"),
	_101("推荐")
	;
	
	private String text;
	
	
}
