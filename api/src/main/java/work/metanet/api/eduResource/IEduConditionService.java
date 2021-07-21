package work.metanet.api.eduResource;

import java.util.List;

import work.metanet.api.eduDirectory.protocol.ReqEduCondition;
import work.metanet.api.eduDirectory.protocol.ReqEduCondition.RespEduCondition;

public interface IEduConditionService {

	/**
	 * @Description: 筛选条件
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/02
	 */
	List<RespEduCondition> eduCondition() throws Exception;
	
	/**
	 * @Description: 筛选条件-其他
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/02
	 */
	List<RespEduCondition> eduConditionOther() throws Exception;
	
	/**
	 * @Description: 筛选条件-主题
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/02
	 */
	List<RespEduCondition> eduConditionTheme(ReqEduCondition req) throws Exception; 
	
	/**
	 * @Description: 筛选条件-动态所有
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/02
	 */
	List<RespEduCondition> eduConditionDynamicAll(ReqEduCondition req) throws Exception; 
	
}
