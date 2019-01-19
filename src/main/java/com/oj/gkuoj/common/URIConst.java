package com.oj.gkuoj.common;

import java.util.Arrays;

/**
 * @author m969130721@163.com
 * @date 19-1-2 下午8:45
 */
public final class URIConst {

    public static final String[] VALIDATE_CODE_ARRAY_URI = new String[]{
            "/user/sendRegisterEmail", "/user/loginProcess",
            "/user/sendForgetEmail"
    };

    public static final String[] NOT_ALLOWED_ARRAY_URI = new String[]{
            "/admin/**"
    };

}
