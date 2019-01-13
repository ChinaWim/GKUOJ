package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class BlogComment implements Serializable {

    private static final long serialVersionUID = -2919150742475331L;

    private Integer id;

    private Integer userId;

    private Integer blogId;

    private String content;

    private Date createTime;

    private Date updateTime;

    public BlogComment(Integer id, Integer userId, Integer blogId, String content, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.blogId = blogId;
        this.content = content;
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
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}