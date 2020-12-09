package com.yyb.learn.jbasics.utils;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public Result(){}

    public Result(boolean isSuccess, int status){
//        this.isSuccess = isSuccess;
        this.status = status;
    }

    public Result(boolean isSuccess, int status, T data){
//        this.isSuccess = isSuccess;
        this.status = status;
        this.data = data;
    }

    public Result(boolean isSuccess, int status, String msg){
//        this.isSuccess = isSuccess;
        this.status = status;
        this.msg = msg;
    }

    public Result(boolean isSuccess, int status, String msg, T data){
//        this.isSuccess = isSuccess;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
