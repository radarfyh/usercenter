package work.metanet.questionnaire.dao;

import work.metanet.api.questionnaire.protocol.ReqRemoveQuestionnaire;
import work.metanet.api.questionnaire.protocol.ReqSaveQuestionnaire;
import work.metanet.api.questionnaire.protocol.ReqQuestionnaireInfo;
import work.metanet.api.questionnaire.protocol.ReqQuestionnaireList;
import work.metanet.base.RespPaging;
import work.metanet.model.Questionnaire;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author edison
 * @Description 调查表映射器
 * @date 2023年04月18日
 */
public interface QuestionnaireMapper extends Mapper<Questionnaire> {

    /**
     * 查询调查表列表
     * @param req
     * @return
     * @throws Exception
     */
    List<ReqQuestionnaireList.RespQuestionnaireList> getQuestionnaireList(Map<String,Object> req) throws Exception;

    /**
     * 获取调查表详情
     * @param req
     * @return
     * @throws Exception
     */
    ReqQuestionnaireInfo.RespQuestionnaireInfo getQuestionnaireInfo(Map<String,Object> req) throws Exception;

    /**
     * 保存调查表
     * @param req
     * @return
     * @throws Exception
     */
    int saveQuestionnaire(Map<String,Object> req) throws Exception;

    /**
     * 新增调查表
     * @param req
     * @return
     * @throws Exception
     */
    int insertQuestionnaire(Map<String,Object> req) throws Exception;

    /**
     * 删除调查表
     * @param list
     * @return
     * @throws Exception
     */
    int removeQuestionnaire(List<ReqRemoveQuestionnaire> list) throws Exception;
}
