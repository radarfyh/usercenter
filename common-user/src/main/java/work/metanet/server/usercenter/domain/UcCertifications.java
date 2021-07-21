package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 认证信息
 * @author EdisonFeng
 * @DateTime 2021年6月8日 Copyright(c) 2021. All Rights Reserved
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcCertifications extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 5024605081289711176L;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 认证方式 0短信 1银行 2人脸识别 3公有云实名认证服务 4身份证查验 5护照查验
	 */
	private int mode;

	/**
	 * 是否已通过实名认证 0未通过 1通过
	 */
	private int certfiedRealName;

	private String organizationRealName;

	private String certfiedResult;

	private String name;

	private String idCardMumber;

	private String passportNumber;

	private String drivingLicenseNumber;

	/**
	 * 认证资料链接
	 */
	private String url;
}
