package work.metanet.client.gateway.enums;

import lombok.Getter;

/**
 * @Description 响应码枚举
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS("200", "SUCCESS"),
    BAD_REQUEST("400", "BAD_REQUEST"),
    FAIL("500", "FAIL"),
    ;

    private String code;

    private String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
