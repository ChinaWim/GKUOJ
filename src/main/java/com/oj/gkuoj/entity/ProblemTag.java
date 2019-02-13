package com.oj.gkuoj.entity;

import java.util.Date;

public class ProblemTag {
    private Integer id;

    private Integer pId;

    private Integer tId;

    private Date createTime;

    private Date updateTime;

    public ProblemTag(Integer id, Integer pId, Integer tId, Date createTime, Date updateTime) {
        this.id = id;
        this.pId = pId;
        this.tId = tId;
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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
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
}