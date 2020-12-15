package com.yyb.common.dtos.error;

import org.springframework.http.HttpStatus;

/**
 * 错误码分类
 */
public enum Error {
    /**
     * 1.公共错误码
     */
    SERVER_ERROR(HttpStatus.BAD_REQUEST.value() * 10, "NORMAL SERVER ERROR"),
    PARAM_ERROR(HttpStatus.BAD_REQUEST.value() * 10 + 1, "PARAM ERROR"),
    ALREADY_ADD(HttpStatus.BAD_REQUEST.value() * 10 + 2, "ALREADY ADD"),
    ALREADY_UPD(HttpStatus.BAD_REQUEST.value() * 10 + 3, "ALREADY UPDATE"),
    ALREADY_DEL(HttpStatus.BAD_REQUEST.value() * 10 + 4, "ALREADY DELETE"),

    METHOD_NOT_ALLOWED(HttpStatus.BAD_REQUEST.value() * 10 + 5, "METHOD NOT ALLOWED")

    /**
     * 2.业务处理错误码
     */
    ;

    private final int errorCode;
    private final String errorMsg;

    Error(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
