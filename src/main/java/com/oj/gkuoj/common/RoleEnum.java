package com.oj.gkuoj.common;

/**
 * @author m969130721@163.com
 * @date 19-1-3 下午6:36
 */
public enum RoleEnum {

    /**
     * 普通用户
     */
    USER("ROLE_USER"),


    /**
     * 　管理员
     */
    ADMIN("ROLE_ADMIN");

    private String name;

    RoleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
