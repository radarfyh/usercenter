package work.metanet.exception;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalRpcExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultResponse<?> validHandler(MethodArgumentNotValidException ex) {
        log.error("ValidException:", ex);

        List<ObjectError> list = ex
                .getBindingResult().getAllErrors();

        String errorMsg = StringUtils.defaultString(list.get(0).getDefaultMessage(), "参数错误");

        return ResultResponseEnum.INVALID_REQUEST.resultResponse().setMessage(errorMsg);
    }

    @ResponseBody
    @ExceptionHandler(value = MetanetException.class)
    public ResultResponse<?> bussinessHandler(MetanetException ex) {

        log.error("BussinessException:", ex);

        return ResultResponseEnum.SERVER_FAILURE.resultResponse()
        		.setResponseCode(ex.getResponseCode())
        		.setMessage(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultResponse<?> errorHandler(Exception e) {

        log.error("uncaught Exception:", e);

        ResultResponse<?> resp;
        if (e instanceof RpcException) {
            resp = ResultResponseEnum.FAILURE_RPC.resultResponse();
        } else if (e instanceof RuntimeException) {
            resp = ResultResponseEnum.FAILURE_RUNTIME.resultResponse();
        } else {
        	resp = ResultResponseEnum.SERVER_FAILURE.resultResponse();
        }

        return resp;
    }
}
