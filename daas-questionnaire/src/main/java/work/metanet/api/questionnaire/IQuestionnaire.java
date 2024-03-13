package work.metanet.api.questionnaire;

import work.metanet.api.questionnaire.protocol.*;
import work.metanet.base.RespPaging;

import java.util.List;

/**
 * @author edison
 * @Description 调查表
 * @DateTime 2023年4月17日
 * Copyright(c) 2023. All Rights Reserved
 */

public interface IQuestionnaire {

    /**
     * 查询调查表列表
     * @param req
     * @return
     * @throws Exception
     */
    RespPaging<ReqQuestionnaireList.RespQuestionnaireList> getQuestionnaireList(ReqQuestionnaireList req) throws Exception;

    /**
     * 获取调查表详情
     * @param req
     * @return
     * @throws Exception
     */
    ReqQuestionnaireInfo.RespQuestionnaireInfo getQuestionnaireInfo(ReqQuestionnaireInfo req) throws Exception;

    /**
     * 保存调查表
     * @param req
     * @return
     * @throws Exception
     */
    ReqSaveQuestionnaire.RespSaveQuestionnaire saveQuestionnaire(ReqSaveQuestionnaire req) throws Exception;

    /**
     * 新增调查表
     * @param req
     * @return
     * @throws Exception
     */
    ReqSaveQuestionnaire.RespSaveQuestionnaire insertQuestionnaire(ReqInsertQuestionnaire req) throws Exception;

    /**
     * 删除调查表
     * @param req
     * @return
     * @throws Exception
     */
    List<ReqRemoveQuestionnaire> removeQuestionnaire(List<ReqRemoveQuestionnaire> req) throws Exception;
}
