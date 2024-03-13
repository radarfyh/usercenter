package work.metanet.questionnaire.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import org.apache.dubbo.config.annotation.Service;
import work.metanet.questionnaire.dao.QuestionnaireMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.questionnaire.IQuestionnaire;
import work.metanet.api.questionnaire.protocol.ReqQuestionnaireList;
import work.metanet.api.questionnaire.protocol.ReqQuestionnaireInfo;
import work.metanet.api.questionnaire.protocol.ReqSaveQuestionnaire;
import work.metanet.api.questionnaire.protocol.ReqInsertQuestionnaire;
import work.metanet.api.questionnaire.protocol.ReqRemoveQuestionnaire;
import work.metanet.base.RespPaging;
import work.metanet.exception.DaasException;
import org.apache.commons.lang3.StringUtils;
//import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author edison
 * @Description 调查表服务
 * @date 2023年04月18日
 */
//@DubboService
@Service
public class QuestionnaireService implements IQuestionnaire {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public RespPaging<ReqQuestionnaireList.RespQuestionnaireList> getQuestionnaireList(ReqQuestionnaireList req) throws Exception {
        RespPaging<ReqQuestionnaireList.RespQuestionnaireList> respPaging = new RespPaging<>();
        PageHelper.startPage(req.getPageNum(), req.getPageSize());

        List<ReqQuestionnaireList.RespQuestionnaireList> questionnaireList =  questionnaireMapper.getQuestionnaireList(BeanUtil.beanToMap(req));
        PageInfo<ReqQuestionnaireList.RespQuestionnaireList> respQuestionnaireListPageInfo = new PageInfo<>(questionnaireList);
        respPaging.setList(questionnaireList);
        BeanUtil.copyProperties(questionnaireList, respPaging);
        return respPaging;
    }

    @Override
    public ReqQuestionnaireInfo.RespQuestionnaireInfo getQuestionnaireInfo(ReqQuestionnaireInfo req) throws Exception {
        ReqQuestionnaireInfo.RespQuestionnaireInfo questionnaireInfo = null;
        try {
            questionnaireInfo = questionnaireMapper.getQuestionnaireInfo(BeanUtil.beanToMap(req));
        } catch (Exception e) {
            throw DaasException.of().setMsg("获取调查表信息异常" + e.getMessage());
        }
        if (questionnaireInfo == null) {
            throw DaasException.of().setMsg("数据为空");
        }

        return questionnaireInfo;
    }

    @Transactional
    @Override
    public ReqSaveQuestionnaire.RespSaveQuestionnaire saveQuestionnaire(ReqSaveQuestionnaire req) throws Exception {
        ReqSaveQuestionnaire.RespSaveQuestionnaire respSaveQuestionnaire = new ReqSaveQuestionnaire.RespSaveQuestionnaire();
        ReqQuestionnaireInfo.RespQuestionnaireInfo questionnaireInfo = new ReqQuestionnaireInfo.RespQuestionnaireInfo();
        int updateRows = 0;
        try {
            updateRows = questionnaireMapper.saveQuestionnaire(BeanUtil.beanToMap(req));
        } catch (Exception e) {
            throw DaasException.of().setMsg("修改调查表异常" + e.getMessage());
        }
        if (updateRows <= 0) {
            throw DaasException.of().setMsg("修改数据为空");
        } else {
            BeanUtil.copyProperties(req, respSaveQuestionnaire);
        }
        return respSaveQuestionnaire;
    }

    @Override
    public ReqSaveQuestionnaire.RespSaveQuestionnaire insertQuestionnaire(ReqInsertQuestionnaire req) throws Exception {
        ReqSaveQuestionnaire.RespSaveQuestionnaire respSaveQuestionnaire = new ReqSaveQuestionnaire.RespSaveQuestionnaire();
        int insertRows = 0;
        try {
            req.setId(IdUtil.fastSimpleUUID());
            insertRows = questionnaireMapper.insertQuestionnaire(BeanUtil.beanToMap(req));
        } catch (Exception e) {
            throw DaasException.of().setMsg("新增调查表异常" + e.getMessage());
        }
        if (insertRows <= 0) {
            throw DaasException.of().setMsg("新增数据为空");
        } else {
            BeanUtil.copyProperties(req, respSaveQuestionnaire);
        }
        return respSaveQuestionnaire;
    }

    @Override
    public List<ReqRemoveQuestionnaire> removeQuestionnaire(List<ReqRemoveQuestionnaire> list) throws Exception {
        int removeRows = 0;
        try {
            removeRows = questionnaireMapper.removeQuestionnaire(list);
        } catch (Exception e) {
            throw DaasException.of().setMsg("删除调查表异常" + e.getMessage());
        }
        if (removeRows <= 0) {
            throw DaasException.of().setMsg("删除数据为空");
        }
        return list;
    }
}

