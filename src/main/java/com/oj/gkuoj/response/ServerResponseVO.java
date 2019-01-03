package com.oj.gkuoj.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.oj.gkuoj.common.ResponseCodeEnum;

import java.io.Serializable;

/**
 * @author m969130721@163.com
 * @date 18-5-27 下午5:29
 */
//保证序列化json的时候null值不序列化
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponseVO<T> implements Serializable {

    private int status;

    private String msg;

    private T data;

    private ServerResponseVO() {
    }

    private ServerResponseVO(int status) {
        this.status = status;
    }

    private ServerResponseVO(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponseVO(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponseVO(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;

    }


    public static <T> ServerResponseVO<T> createBySuccess() {
        return new ServerResponseVO<>(ResponseCodeEnum.SUCCESS.getCode());
    }

    public static <T> ServerResponseVO<T> createBySuccessMessage(String msg) {
        return new ServerResponseVO<>(ResponseCodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponseVO<T> createBySuccess(T data) {
        return new ServerResponseVO<>(ResponseCodeEnum.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponseVO<T> createBySuccessMessage(String msg, T data) {
        return new ServerResponseVO<>(ResponseCodeEnum.SUCCESS.getCode(), msg, data);
    }


    public static <T> ServerResponseVO<T> createByError() {
        return new ServerResponseVO<>(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDesc());
    }

    public static <T> ServerResponseVO<T> createByErrorMessage(String msg) {
        return new ServerResponseVO<>(ResponseCodeEnum.ERROR.getCode(), msg);
    }

    public static <T> ServerResponseVO<T> createByErrorCodeMessage(int errorCode, String msg) {
        return new ServerResponseVO<>(errorCode, msg);
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
        return "ServerResponseVO{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
