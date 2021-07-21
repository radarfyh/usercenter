package work.metanet.api.family.protocol;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import work.metanet.api.family.protocol.ReqFamilyMemberInfo.RespFamilyMemberInfo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@ApiModel("请求-家庭成员列表")
@Accessors(chain = true)
@Data
public class ReqFamilyMemberList implements Serializable{
	
	private static final long serialVersionUID = -6457808617344271860L;
	
	@JsonIgnore
	private String joinUserId;
	
	@ApiModel("响应-家庭成员列表")
	@EqualsAndHashCode(callSuper=true)
	@Data
	public static class RespFamilyMemberList extends RespFamilyMemberInfo implements Serializable{
		private static final long serialVersionUID = -4963307395308034601L;
		
	}
	
}
