package work.metanet.client.gateway.exception;

import work.metanet.client.gateway.alarm.EmailAlarm;
import work.metanet.client.gateway.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;

import static java.util.stream.Collectors.joining;

/**
 * @Description 异常处理类
 *  @author EdisonFeng
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @Resource
    private EmailAlarm emailAlarm;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseResult<String> bindExceptionHandler(MethodArgumentNotValidException ex) {
        // 获取校验失败的字段的错误信息
        final String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(joining("\n"));
        log.warn("无效请求参数 message={}", message);
        return ResponseResult.badRequestError(message);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseResult<String> bindExceptionHandler(IllegalArgumentException ex) {
        // 获取校验失败的字段的错误信息
        final String message = ex.getMessage();
        log.warn("无效请求参数 message={}", message, ex);
        return ResponseResult.badRequestError(message);
    }

    /**
     * 包装异常信息返回
     *
     * @param exception Exception
     * @return ResultResponse<Object>
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult<String> handleApiException(Throwable exception) {
        if (exception instanceof ApiException) {
            ApiException e = (ApiException) exception;

            return new ResponseResult<>(e);
        }
        emailAlarm.alarm("服务异常", exception);
        exception.printStackTrace();
        return ResponseResult.fail(exception);
    }

}
