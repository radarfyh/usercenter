package work.metanet.api.family.protocol;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@ApiModel("请求-保存家庭成员")
@Accessors(chain = true)
@Data
public class ReqSaveFamilyMember implements Serializable{
	
	private static final long serialVersionUID = 8877713829043317351L;
	
    @JsonIgnore
    private String createUser;
    @JsonIgnore
    private String updateUser;
    @JsonIgnore
    private String joinUserId;
    
    @ApiModelProperty(value = "家庭成员id")
    private String familyMemberId;
    
    @ApiModelProperty("是否有管理权限-0否/1是")
	private Boolean isManager = false;
	
	@ApiModelProperty("是否人脸识别-0否/1是")
	private Boolean isFace = false;
	
	@ApiModelProperty(value = "关系名称")
    private String relationName = "孩子";

	@ApiModelProperty(value = "昵称", required = true)
	@NotBlank(message = "昵称不能为空")
    private String nickName;
	
	@ApiModelProperty("头像")
    private String headUrl;
	
	@ApiModelProperty(value = "性别-0女/1男",required = true)
	@NotBlank(message = "性别不能为空")
    private String gender;
	
	@ApiModelProperty(value = "生日",required = true)
	@NotBlank(message = "生日不能为空")
	private String birthday;
	
	@ApiModelProperty(value = "年龄")
    private Integer age;
	
	@ApiModelProperty(value = "爱好-多个以/分隔")
    private String hobby;

	@ApiModelProperty(value = "学历-0幼儿园/1小学")
    private String education = "1";

	@ApiModelProperty(value = "年级-1/2/3/4/5/6/7/8/9/10/11/12")
    private String grade = "1";
	
	
	@ApiModel("响应-保存家庭成员")
	@EqualsAndHashCode(callSuper=true)
	@Accessors(chain = true)
	@Data
	public static class RespSaveFamilyMember extends ReqSaveFamilyMember implements Serializable{
		
		private static final long serialVersionUID = -9206398862538029376L;
		
	}
	
}
