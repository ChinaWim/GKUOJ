package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class ProblemTag implements Serializable {
    private Integer id;

    private Integer proId;

    private Integer tagId;

    private Date createTime;

    private Date updateTime;

    public ProblemTag(Integer id, Integer proId, Integer tagId, Date createTime, Date updateTime) {
        this.id = id;
        this.proId = proId;
        this.tagId = tagId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProblemTag() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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
        return "ProblemTag{" +
                "id=" + id +
                ", proId=" + proId +
                ", tagId=" + tagId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}