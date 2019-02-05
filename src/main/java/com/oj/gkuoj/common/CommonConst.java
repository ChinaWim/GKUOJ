package com.oj.gkuoj.common;

/**
 * @author m969130721@163.com
 * @date 19-2-5 下午11:17
 */
public class CommonConst {

    public interface CompetitionStatus {


        /**
         * 未开始
         */
        Integer NOT_STARTED = 1;
        /**
         * 进行中
         */
        Integer PROCESSING = 2;
        /**
         * 已结束
         */
        Integer CLOSE = 3;

        /**
         * 用户已报名
         */
        Integer REGISTERED = 4;
    }


    public interface ProblemUserStatus {
        /**
         * 尝试中
         */
        Integer TRYING = 1;
        /**
         * 通过
         */
        Integer PASSED = 2;
    }

}
