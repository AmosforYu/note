package com.yyb.common.dtos.error;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author Yamos
 * @description ErrorResponse
 * @date 2020/12/15 0015 9:42
 */
public class ErrorResponse {

    /** The res code. */
    private int errorCode;

    /** The res msg. */
    private String errorMsg;

    private String desc;

    private Map<String, Object> extraInfo;

    /**
     * Instantiates a new report exception.
     *
     * @param resCode
     *            the res code
     * @param resMsg
     *            the res msg
     */
    public ErrorResponse(int resCode, String resMsg, String desc, JSONObject extraInfo) {
        this.errorCode = resCode;
        this.errorMsg = resMsg;
        this.desc = desc;
        this.extraInfo = extraInfo;
    }

    public ErrorResponse(Error error, String desc) {
        this.errorCode = error.getErrorCode();
        this.errorMsg = error.getErrorMsg();
        this.desc = desc;
    }

    public Map<String, Object> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Map<String, Object> extraInfo) {
        this.extraInfo = extraInfo;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
