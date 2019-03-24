package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class ProblemTag implements Serializable {

    private static final long serialVersionUID = 3822649254983520795L;

    private Integer id;

    private Integer problemId;

    private Integer tagId;

    private Date createTime;

    private Date updateTime;

    public ProblemTag(Integer id, Integer problemId, Integer tagId, Date createTime, Date updateTime) {
        this.id = id;
        this.problemId = problemId;
        this.tagId = tagId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
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
                ", problemId=" + problemId +
                ", tagId=" + tagId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}