package com.yyb.common.dtos.response;

import com.alibaba.fastjson.JSONObject;

/**
 * 响应分类
 */
public class RespBody {

    private static final int SUCCESS_CODE = 00000;
    private static final String SUCCESS_MSG = "SUCCESS";
    private static final int FAILURE_CODE = 10000;
    private static final String FAILURE_MSG = "FAILURE";

    public static JSONObject success() {
        JSONObject success = new JSONObject();
        success.put("respCode", SUCCESS_CODE);
        success.put("respMsg", SUCCESS_MSG);

        return success;
    }

    public static JSONObject failure() {
        JSONObject success = new JSONObject();
        success.put("respCode", FAILURE_CODE);
        success.put("respMsg", FAILURE_MSG);

        return success;
    }

    public static JSONObject successMsg(String msg) {
        JSONObject success = new JSONObject();
        success.put("respCode", SUCCESS_CODE);
        success.put("respMsg", msg);

        return success;
    }

    public static JSONObject failureMsg(String msg) {
        JSONObject success = new JSONObject();
        success.put("respCode", FAILURE_CODE);
        success.put("respMsg", msg);

        return success;
    }

    public static JSONObject succCodeMsg(int code, String msg) {
        JSONObject success = new JSONObject();
        success.put("respCode", code);
        success.put("respMsg", msg);

        return success;
    }

    public static JSONObject failCodeMsg(int code, String msg) {
        JSONObject success = new JSONObject();
        success.put("respCode", code);
        success.put("respMsg", msg);

        return success;
    }
}
