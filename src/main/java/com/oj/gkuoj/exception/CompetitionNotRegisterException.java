package com.oj.gkuoj.exception;

/**
 * @author m969130721@163.com
 * @date 19-2-6 上午1:44
 */
public class CompetitionNotRegisterException extends ApplicationException{


    private static final long serialVersionUID = -6054403920194096087L;

    public CompetitionNotRegisterException(int status, String msg) {
        super(status, msg);
    }
}
