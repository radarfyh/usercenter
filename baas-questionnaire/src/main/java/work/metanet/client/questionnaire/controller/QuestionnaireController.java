package work.metanet.client.questionnaire.controller;

import work.metanet.api.questionnaire.IQuestionnaire;
import work.metanet.api.questionnaire.protocol.*;
import work.metanet.base.RespPaging;
import work.metanet.base.Result;
import work.metanet.base.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author edison
 * @Description 调查表控制器
 * @DateTime 2023年4月18日
 */
@Api(tags = {"调查表"})
@RestController
@RequestMapping("api/Questionnaire")
public class QuestionnaireController extends BaseController {

    @DubboReference
    private IQuestionnaire questionnaireService;

    @ApiOperation(value = "调查表列表")
    @PostMapping("QuestionnaireList")
    public Result<RespPaging<ReqQuestionnaireList.RespQuestionnaireList>> getQuestionnaireList(@RequestBody ReqQuestionnaireList req){
        RespPaging<ReqQuestionnaireList.RespQuestionnaireList> questionnaireList = new RespPaging<>();
        try {
            questionnaireList = questionnaireService.getQuestionnaireList(req);
        } catch (Exception e) {
            return ResultMessage.FAILURE.result(questionnaireList).setMsg("未知异常");
        }
        return ResultMessage.SUCCESS.result(questionnaireList);
    }

    @ApiOperation(value = "调查表详情")
    @PostMapping("QuestionnaireInfo")
    public Result<ReqQuestionnaireInfo.RespQuestionnaireInfo> getQuestionnaireInfo(@Valid @RequestBody ReqQuestionnaireInfo req){
        ReqQuestionnaireInfo.RespQuestionnaireInfo questionnaireInfo = new ReqQuestionnaireInfo.RespQuestionnaireInfo();
        try {
            questionnaireInfo = questionnaireService.getQuestionnaireInfo(req);
        } catch (Exception e) {
            return ResultMessage.FAILURE.result(questionnaireInfo).setMsg("未知异常"+e.getMessage());
        }
        return ResultMessage.SUCCESS.result(questionnaireInfo);
    }

    @ApiOperation(value = "调查表修改")
    @PostMapping("QuestionnaireUpdate")
    public Result<ReqSaveQuestionnaire.RespSaveQuestionnaire> updateQuestionnaire(@Valid @RequestBody ReqSaveQuestionnaire req){
        ReqSaveQuestionnaire.RespSaveQuestionnaire respSaveQuestionnaire = new ReqSaveQuestionnaire.RespSaveQuestionnaire();
        try {
            respSaveQuestionnaire = questionnaireService.saveQuestionnaire(req);
        } catch (Exception e) {
            return ResultMessage.FAILURE.result(respSaveQuestionnaire).setMsg("未知异常");
        }
        return ResultMessage.SUCCESS.result(respSaveQuestionnaire);
    }

    @ApiOperation(value = "调查表新增")
    @PostMapping("QuestionnaireInsert")
    public Result<ReqSaveQuestionnaire.RespSaveQuestionnaire> insertQuestionnaire(@Valid @RequestBody ReqInsertQuestionnaire req){
        ReqSaveQuestionnaire.RespSaveQuestionnaire respSaveQuestionnaire = new ReqSaveQuestionnaire.RespSaveQuestionnaire();
        try {
            respSaveQuestionnaire = questionnaireService.insertQuestionnaire(req);
            System.out.println(respSaveQuestionnaire);
        } catch (Exception e) {
            return ResultMessage.FAILURE.result(respSaveQuestionnaire).setMsg("");
        }
        return ResultMessage.SUCCESS.result(respSaveQuestionnaire);
    }

    @ApiOperation(value = "调查表删除")
    @PostMapping("QuestionnaireRemove")
    public Result<?> removeQuestionnaire(@Valid @RequestBody List<ReqRemoveQuestionnaire> list){
        List<ReqRemoveQuestionnaire> reqRemoveQuestionnaires = null;
        try {
            reqRemoveQuestionnaires = questionnaireService.removeQuestionnaire(list);
        } catch (Exception e) {
            return ResultMessage.FAILURE.result().setMsg("未知异常");
        }
        return ResultMessage.SUCCESS.result(reqRemoveQuestionnaires);
    }
}

