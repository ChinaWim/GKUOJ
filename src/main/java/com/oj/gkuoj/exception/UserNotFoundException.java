package com.oj.gkuoj.exception;

/**
 * @author m969130721@163.com
 * @date 19-1-3 下午6:15
 */
public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException() {
        super("用户未找到");
    }
}
