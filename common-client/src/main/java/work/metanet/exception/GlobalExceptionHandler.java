package work.metanet.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 全局异常处理
 * @Author Louis & Edison & W.B.
 * @DateTime 2019/11/29
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
//	@DubboReference
//	private ISystemLogService systemLogService;
	
    @ExceptionHandler(value = MetanetException.class)//使用此注解来指定获取自定义异常类，返回给前端 json 格式错误数据
    public ResultResponse<?> handlerException(MetanetException e){
    	log.error("---异常---:{}", ExceptionUtils.getStackTrace(e));
    	
		return ResultResponse.builder().responseCode(ResultResponseEnum.SERVER_FAILURE.getResponseCode())
				.message(e.getMessage())
				.successFlag(e.getSuccessFlag())
				.build();

    }
    
//    @ExceptionHandler(value = MetanetException.class)//使用此注解来指定获取自定义异常类，返回给前端 json 格式错误数据
//    public ResultResponse<?> handlerException(HttpServletRequest request, HttpServletResponse response, MetanetException e){
//
//		return saveExceptionLog(request, response, e);
//
//    }    
    
//    private ResultResponse<?> saveExceptionLog(HttpServletRequest request, HttpServletResponse response, MetanetException e) {
//    	log.debug("saveExceptionLog 进入");
//
//    	ReqSaveOperLog operLog = (ReqSaveOperLog) HttpServletRequestUtil.getRequest().getAttribute("operLog");
//    	operLog.setTime(System.currentTimeMillis() - operLog.getStartTime());
//    	
//    	operLog.setResp(ExceptionUtils.getStackTrace(e));
//		
//		try {
//			log.error(JSONUtil.toJsonStr(operLog));
//			//kafkaUtil.send(new ProducerRecord<String, String>(constant.kafka_topic_operLog, operLog.getTraceId(), JSONUtil.toJsonStr(operLog)));
//			systemLogService.saveOperLog(operLog);
//		} catch (Exception e1) {
//			log.error("---操作日志保存异常---:{}",ExceptionUtils.getStackTrace(e1));
//		}
//		
//		return ResultResponse.builder().responseCode(ResultResponseEnum.SERVER_FAILURE.getResponseCode())
//				.message(e.getMessage())
//				.successFlag(e.getSuccessFlag())
//				.build();
//    }
}