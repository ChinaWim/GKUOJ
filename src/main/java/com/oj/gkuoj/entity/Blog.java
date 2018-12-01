package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private Integer id;

    private Integer userId;

    private String title;

    private String content;

    private Integer problemId;

    private Integer viewCount;

    private Integer upCount;

    private Integer downCount;

    private Date createTime;

    private Date updateTime;

    public Blog(Integer id, Integer userId, String title, String content, Integer problemId, Integer viewCount, Integer upCount, Integer downCount, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.problemId = problemId;
        this.viewCount = viewCount;
        this.upCount = upCount;
        this.downCount = downCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Blog() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getUpCount() {
        return upCount;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
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
        return "Blog{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", problemId=" + problemId +
                ", viewCount=" + viewCount +
                ", upCount=" + upCount +
                ", downCount=" + downCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}