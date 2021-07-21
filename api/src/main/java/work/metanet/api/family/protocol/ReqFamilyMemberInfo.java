package work.metanet.api.family.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("请求-家庭成员信息")
@Accessors(chain = true)
@Data
public class ReqFamilyMemberInfo implements Serializable{

	private static final long serialVersionUID = 5448598344020657643L;
	
	@ApiModelProperty(value = "家庭成员id", required = true)
	@NotBlank(message = "家庭成员id不能为空")
	private String familyMemberId;
	
	
	@ApiModel("响应-家庭成员信息")
	@Data
	public static class RespFamilyMemberInfo implements Serializable{
		
		private static final long serialVersionUID = -4963307395308034601L;
		
		@ApiModelProperty(value = "家庭成员id")
		private String familyMemberId;
		
		@ApiModelProperty("是否有管理权限-0否/1是")
		private Boolean isManager;
		
		@ApiModelProperty("是否人脸识别-0否/1是")
		private Boolean isFace;

	    @ApiModelProperty(value = "关系名称")
	    private String relationName;
		
		@ApiModelProperty(value = "昵称")
	    private String nickName;
		
		@ApiModelProperty("头像")
	    private String headUrl;

		@ApiModelProperty(value = "性别-0女/1男")
	    private String gender;
		
		@ApiModelProperty(value = "生日-2020-01-01")
		private String birthday;
		
		@ApiModelProperty(value = "年龄")
	    private Integer age;
		
		@ApiModelProperty(value = "爱好-多个以/分隔")
	    private String hobby;
		
		@ApiModelProperty(value = "学历-0幼儿园/1小学")
	    private String education;
		
		@ApiModelProperty(value = "年级-1/2/3/4/5/6/7/8/9")
	    private String grade;
		
		@ApiModelProperty(value = "奖励星星数")
		private Integer rewardNumber;
		
	}

}
