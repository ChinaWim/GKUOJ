package com.oj.gkuoj.common;

/**
 * @author m969130721@163.com
 * @date 19-1-3 下午6:36
 */
public enum RoleEnum {

    /**
     * 普通用户
     */
    USER(2,"ROLE_USER"),

    /**
     * 　管理员
     */
    ADMIN(1,"ROLE_ADMIN");

    private Integer id;

    private String name;

    RoleEnum(Integer id,String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
