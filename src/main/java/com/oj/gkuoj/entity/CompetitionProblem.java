package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class CompetitionProblem implements Serializable {
    private Integer id;

    private Integer socre;

    private Integer problemId;

    private Date createTime;

    private Date updateTime;

    public CompetitionProblem(Integer id, Integer socre, Integer problemId, Date createTime, Date updateTime) {
        this.id = id;
        this.socre = socre;
        this.problemId = problemId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CompetitionProblem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSocre() {
        return socre;
    }

    public void setSocre(Integer socre) {
        this.socre = socre;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
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
        return "CompetitionProblem{" +
                "id=" + id +
                ", socre=" + socre +
                ", problemId=" + problemId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}