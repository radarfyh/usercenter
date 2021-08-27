package work.metanet.api.userScore;

import java.math.BigDecimal;
import java.util.Date;

import work.metanet.api.userScore.protocol.ReqLearningChangeUserScore;
import work.metanet.api.userScore.protocol.ReqUserScoreList;
import work.metanet.api.userScore.protocol.ReqUserScoreList.RespUserScoreList;
import work.metanet.api.userScore.vo.UserScoreVo;
import work.metanet.base.RespPaging;

public interface IUserScoreService {
	
	/**
	 * @Description: 初始化用户积分
	 * @Author edison F. & w.b.
	 * @DateTime 2021/07/30
	 */
	UserScoreVo initUserScore(String userId) throws Exception;
	
	/**
	 * @Description: 触发用户积分
	 * @Author edison F. & w.b.
	 * @DateTime 2021/07/30
	 */
	void changeUserScore(String userId, BigDecimal changeValue, String changeType, String joinId, String remark, Date createTime) throws Exception;
	
	/**
	 * @Description: 学习-触发用户积分
	 * @Author edison F. & w.b.
	 * @DateTime 2021/07/30
	 */
	void learningChangeUserScore(String userId, ReqLearningChangeUserScore req) throws Exception;
	
	/**
	 * @Description: 用户积分列表
	 * @Author edison F. & w.b.
	 * @DateTime 2021/07/08
	 */
	RespPaging<RespUserScoreList> userScoreList(ReqUserScoreList req) throws Exception;
	
}
