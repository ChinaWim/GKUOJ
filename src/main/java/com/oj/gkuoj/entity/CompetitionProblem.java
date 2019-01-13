package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class CompetitionProblem implements Serializable {
    private static final long serialVersionUID = -2735818548511091887L;

    private Integer id;

    private Integer compId;

    private Integer score;

    private Integer problemId;

    private Date createTime;

    private Date updateTime;

    public CompetitionProblem(Integer id, Integer compId, Integer score, Integer problemId, Date createTime, Date updateTime) {
        this.id = id;
        this.compId = compId;
        this.score = score;
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

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
                ", compId=" + compId +
                ", score=" + score +
                ", problemId=" + problemId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}