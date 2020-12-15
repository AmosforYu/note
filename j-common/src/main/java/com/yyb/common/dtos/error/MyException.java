package com.yyb.common.dtos.error;

import java.io.Serializable;
import java.util.Map;

public class MyException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -1961052935776957652L;

    private Error error;

    private String desc;

    private Map<Object, Object> extraInfo;

    public MyException(Error error, String desc) {
        super("code:" + error.getErrorCode() + ",msg:" + error.getErrorMsg());
        this.error = error;
        this.desc = desc;
        setMyExceptionStackTrace();
    }

    private void setMyExceptionStackTrace() {
        StackTraceElement[] elements = getStackTrace();
        int len = elements == null ? 0 : elements.length;
        int minLen = Math.min(5, len);
        StackTraceElement[] newStack = new StackTraceElement[minLen];
        for (int i = 0; i < minLen; i++) {
            newStack[i] = elements[i];
        }
        setStackTrace(newStack);
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<Object, Object> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Map<Object, Object> extraInfo) {
        this.extraInfo = extraInfo;
    }
}
