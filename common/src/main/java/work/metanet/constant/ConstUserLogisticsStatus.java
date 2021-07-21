
package work.metanet.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 用户物流状态
 * @author EdisonFeng
 * @DateTime 2021年6月10日
 * Copyright(c) 2021. All Rights Reserved
 */
@AllArgsConstructor
@Getter
public enum ConstUserLogisticsStatus {
	UNKNOWN(0,"未知"),
	PICKING(1,"准备中"),
	ON_PASSAGE(2,""),
	THANSFER_WAREHOUSE(3,"中转仓库"),
	ARRIVED(4,"已到达"),
	SIGNED(5,"已签收");
	
	private int val;
	private String text;
}
