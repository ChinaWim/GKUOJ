package com.oj.gkuoj.entity;

import java.util.Date;

public class Blog {
    private Integer id;

    private Integer userId;

    private Integer bcId;

    private String title;

    private String content;

    private String htmlContent;

    private String tags;

    private Integer viewCount;

    private Date createTime;

    private Date updateTime;

    public Blog(Integer id, Integer userId, Integer bcId, String title, String content, String htmlContent, String tags, Integer viewCount, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.bcId = bcId;
        this.title = title;
        this.content = content;
        this.htmlContent = htmlContent;
        this.tags = tags;
        this.viewCount = viewCount;
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

    public Integer getBcId() {
        return bcId;
    }

    public void setBcId(Integer bcId) {
        this.bcId = bcId;
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

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent == null ? null : htmlContent.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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