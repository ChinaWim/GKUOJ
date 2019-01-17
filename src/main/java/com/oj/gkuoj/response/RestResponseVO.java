package com.oj.gkuoj.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.oj.gkuoj.common.RestResponseEnum;

import java.io.Serializable;

/**
 * @author m969130721@163.com
 *  @date 18-5-27 下午5:29
 * 保证序列化json的时候null值不序列化
 * @param <T>
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RestResponseVO<T> implements Serializable {

    private Integer status;

    private String msg;

    private T data;

    private RestResponseVO() {
    }

    private RestResponseVO(int status) {
        this.status = status;
    }

    private RestResponseVO(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private RestResponseVO(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private RestResponseVO(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;

    }


    public static <T> RestResponseVO<T> createBySuccess() {
        return new RestResponseVO<>(RestResponseEnum.SUCCESS.getStatus());
    }

    public static <T> RestResponseVO<T> createBySuccessMessage(String msg) {
        return new RestResponseVO<>(RestResponseEnum.SUCCESS.getStatus(), msg);
    }

    public static <T> RestResponseVO<T> createBySuccess(T data) {
        return new RestResponseVO<>(RestResponseEnum.SUCCESS.getStatus(), data);
    }

    public static <T> RestResponseVO<T> createBySuccessMessage(String msg, T data) {
        return new RestResponseVO<>(RestResponseEnum.SUCCESS.getStatus(), msg, data);
    }


    public static <T> RestResponseVO<T> createByError() {
        return new RestResponseVO<>(RestResponseEnum.ERROR.getStatus(), RestResponseEnum.ERROR.getDesc());
    }

    public static <T> RestResponseVO<T> createByErrorEnum(RestResponseEnum restResponseEnum) {
        return new RestResponseVO<>(restResponseEnum.getStatus(), restResponseEnum.getDesc());
    }


    public static <T> RestResponseVO<T> createByErrorMessage(String msg) {
        return new RestResponseVO<>(RestResponseEnum.ERROR.getStatus(), msg);
    }

    public static <T> RestResponseVO<T> createByErrorStatusMessage(int errorStatus, String msg) {
        return new RestResponseVO<>(errorStatus, msg);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status.equals(RestResponseEnum.SUCCESS.getStatus()) ;
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
        return "RestResponseVO{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
