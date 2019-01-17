package com.oj.gkuoj.common;

/**
 * @author m969130721@163.com
 * @date 19-1-2 下午8:45
 */
public final class URIConst {

    public static final String LOGIN_PROCESS_URI = "/user/loginProcess";

    public static final String LOGIN_PAGE_URI = "/user/login";

    public static final String SEND_EMAIL_URI = "/user/sendEmail";


    public static final String[] PERMIT_ARRAY = new String[]{
            "/css/**","/js/**","/fonts/**","/img/**",
            "/vendors/**","/user/registerPage","/validate/**",
            "/index",SEND_EMAIL_URI

    };

}
