package com.oj.gkuoj.common;

/**
 * @author m969130721@163.com
 * @date 19-3-17 上午1:41
 */
public enum UserFlagEnum {
    DELETED(2, "已删除"),
    LOCK(1, "已冻结"),
    ACTIVE(0, "正常");
    private Integer id;
    private String desc;

    UserFlagEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
