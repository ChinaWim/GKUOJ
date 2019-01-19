package com.oj.gkuoj.common;

/**
 * @author m969130721@163.com
 * @date 19-1-2 下午6:43
 */
public final class SessionKeyConst {

    /**
     * 图形验证码
     */
    public static final String IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";



    interface TokenPrefix{
        /**
         * 注册 prefix
         */
        String TOKEN_REGISTER = "TOKEN_REGISTER_";

        /**
         * 重置密码 prefix
         */
        String TOKEN_REST_PASSWORD ="TOKEN_REST_PASSWORD_";

    }

}
