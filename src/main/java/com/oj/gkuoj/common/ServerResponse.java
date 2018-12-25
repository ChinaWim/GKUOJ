package com.oj.gkuoj.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @author m969130721@163.com
 * @date 18-5-27 下午5:29
 */
//保证序列化json的时候null值不序列化
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;

    private String msg;

    private T data;

    private ServerResponse() {
    }

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;

    }


    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<>(ResponseCodeEnum.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<>(ResponseCodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<>(ResponseCodeEnum.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg, T data) {
        return new ServerResponse<>(ResponseCodeEnum.SUCCESS.getCode(), msg, data);
    }


    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<>(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String msg) {
        return new ServerResponse<>(ResponseCodeEnum.ERROR.getCode(), msg);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String msg) {
        return new ServerResponse<>(errorCode, msg);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCodeEnum.SUCCESS.getCode();
    }


    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
