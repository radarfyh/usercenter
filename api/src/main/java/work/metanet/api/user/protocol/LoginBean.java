package work.metanet.api.user.protocol;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录接口封装对象
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@ApiModel("请求-图片验证码登录")
@Data
public class LoginBean {

	@ApiModelProperty(value = "账号", required = true)
	private String account;
	
	@ApiModelProperty(value = "密码", required = true)
	private String password;
	
	@ApiModelProperty(value = "图片验证码", required = true)
	private String captcha;
}
