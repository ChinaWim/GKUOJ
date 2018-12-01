package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class BlogComment implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer blogId;

    private String content;

    private Integer viewCount;

    private Integer upCount;

    private Integer downCount;

    private Date createTime;

    private Date updateTime;

    public BlogComment(Integer id, Integer userId, Integer blogId, String content, Integer viewCount, Integer upCount, Integer downCount, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.blogId = blogId;
        this.content = content;
        this.viewCount = viewCount;
        this.upCount = upCount;
        this.downCount = downCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BlogComment() {
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

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        return "BlogComment{" +
                "id=" + id +
                ", userId=" + userId +
                ", blogId=" + blogId +
                ", content='" + content + '\'' +
                ", viewCount=" + viewCount +
                ", upCount=" + upCount +
                ", downCount=" + downCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}