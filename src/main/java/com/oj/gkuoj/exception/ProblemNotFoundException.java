package com.oj.gkuoj.exception;

/**
 * @author m969130721@163.com
 * @date 19-1-3 下午6:17
 */
public class ProblemNotFoundException extends ApplicationException {
    public ProblemNotFoundException() {
        super("题目未找到");
    }
}
