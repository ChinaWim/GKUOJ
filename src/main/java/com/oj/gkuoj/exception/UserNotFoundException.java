package com.oj.gkuoj.exception;

/** 用户未找到
 * @author m969130721@163.com
 * @date 19-1-3 下午6:15
 */
public class UserNotFoundException extends ApplicationException {

    private static final long serialVersionUID = -6543240172880562733L;

    public UserNotFoundException(int status, String msg) {
        super(status,msg);
    }
}
