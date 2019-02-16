package com.oj.gkuoj.exception;

/**
 * @author m969130721@163.com
 * @date 19-2-6 上午1:44
 */
public class CompetitionNotFoundException extends ApplicationException{


    private static final long serialVersionUID = -997462919114053391L;

    public CompetitionNotFoundException(int status, String msg) {
        super(status, msg);
    }
}
