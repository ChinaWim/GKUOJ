package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class Sign implements Serializable {
    private Integer id;

    private Integer userId;

    private String mood;

    private Date createTime;

    private Date updateTime;

    public Sign(Integer id, Integer userId, String mood, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.mood = mood;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Sign() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood == null ? null : mood.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", userId=" + userId +
                ", mood='" + mood + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}