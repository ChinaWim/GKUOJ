package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class CompetitionResult implements Serializable {
    private Integer id;

    private Integer compProId;

    private Integer userId;

    private Integer status;

    private String type;

    private Long time;

    private Long memory;

    private String sourceCode;

    private Date createTime;

    private Date updateTime;

    public CompetitionResult(Integer id, Integer compProId, Integer userId, Integer status, String type, Long time, Long memory, String sourceCode, Date createTime, Date updateTime) {
        this.id = id;
        this.compProId = compProId;
        this.userId = userId;
        this.status = status;
        this.type = type;
        this.time = time;
        this.memory = memory;
        this.sourceCode = sourceCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CompetitionResult() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompProId() {
        return compProId;
    }

    public void setCompProId(Integer compProId) {
        this.compProId = compProId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode == null ? null : sourceCode.trim();
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
        return "CompetitionResult{" +
                "id=" + id +
                ", compProId=" + compProId +
                ", userId=" + userId +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", memory=" + memory +
                ", sourceCode='" + sourceCode + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}