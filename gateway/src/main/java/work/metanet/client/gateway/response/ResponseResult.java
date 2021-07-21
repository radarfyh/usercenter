package work.metanet.client.gateway.response;

import work.metanet.client.gateway.enums.ResultCodeEnum;
import work.metanet.client.gateway.exception.ApiException;
import lombok.Data;

/**
 * @Description 响应结果
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Data
public class ResponseResult<T> {

    private String code;

    private String msg;

    private T data;

    public ResponseResult() {
    }

    public ResponseResult(ApiException e) {
        this.code = e.getCode();
        this.msg = e.getMessage();
    }

    public ResponseResult(ResultCodeEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = data;
    }

    public ResponseResult(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = (T) "";
    }

    public ResponseResult(T data) {
        this(ResultCodeEnum.SUCCESS, data);
    }

    public ResponseResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseResult<T> fail(String msg, T data) {
        return new ResponseResult<>(ResultCodeEnum.FAIL, data);
    }

    public static <T> ResponseResult<T> fail(String msg) {
        return new ResponseResult<>(ResultCodeEnum.FAIL.getCode(), msg, null);
    }

    public static <T> ResponseResult<T> fail(Throwable e) {
        if (e instanceof ApiException) {
            return new ResponseResult<>((ApiException) e);
        }
        return new ResponseResult<>(ResultCodeEnum.FAIL, null);
    }

    public ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResultCodeEnum.SUCCESS, data);
    }

    public ResponseResult<T> success(String msg, T data) {
        return new ResponseResult<>(ResultCodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResponseResult<T> badRequestError(String message) {
        return new ResponseResult<>(ResultCodeEnum.BAD_REQUEST.getCode(), message, null);
    }

}
