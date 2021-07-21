
package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 物流信息
 * @author EdisonFeng
 * @DateTime 2021年6月8日
 * Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcUserLogistics extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1863421058308320846L;

	private String consignerId;
	
	private int mode;
	
	private String consigneeId;
	
	private String courierNumber;
	
	private Date sentTime;
	
	private int logisticsStatus;
	
	private String logisticsProcess;
	
	private Date receivedTime;
}
