package com.oj.gkuoj.exception;

/**
 * @author m969130721@163.com
 * @date 19-1-3 下午6:14
 */
public class ApplicationException extends RuntimeException{

    private static final long serialVersionUID = 7138332877482642722L;

    public ApplicationException(int status, String msg) {
        super("状态码:" + status + "  内容:" + msg);
    }
}
