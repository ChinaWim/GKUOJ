package com.oj.gkuoj.exception;

/** 用户未找到
 * @author m969130721@163.com
 * @date 19-1-3 下午6:15
 */
public class ProblemNotFoundException extends ApplicationException {


    private static final long serialVersionUID = 3919904865407492637L;

    public ProblemNotFoundException(int status, String msg) {
        super(status,msg);
    }
}
