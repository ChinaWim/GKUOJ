package com.oj.gkuoj.common;

/**
 * @author m969130721@163.com
 * @date 18-5-27 下午5:47
 */
public enum ResponseCodeEnum {
    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 错误
     */
    ERROR(1, "ERROR"),
    /**
     * 需要登录
     */
    NEED_LOGIN(10, "NEED_LOGIN"),
    /**
     * 非法参数
     */
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    private int code;

    private String desc;

    ResponseCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


}
