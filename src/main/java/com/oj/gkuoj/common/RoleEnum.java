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

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
