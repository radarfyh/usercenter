package work.metanet.client.gateway.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description Api异常
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends RuntimeException {

    private String code;

    private String msg;

    public ApiException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
