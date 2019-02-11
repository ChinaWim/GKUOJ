package com.oj.gkuoj.exception;

/**
 * @author m969130721@163.com
 * @date 19-2-11 下午7:58
 */
public class UserUnAuthorizedException extends ApplicationException{

    private static final long serialVersionUID = 2975352570900978436L;

    public UserUnAuthorizedException(int status, String msg) {
        super(status, msg);
    }
}
