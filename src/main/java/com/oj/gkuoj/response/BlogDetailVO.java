package com.oj.gkuoj.response;

import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 19-1-29 下午12:52
 */
public class BlogDetailVO {
    private Integer id;

    private String avatar;

    private Integer userId;

    private String name;

    private String title;

    private String content;

    private String htmlContent;

    private String tags;

    private Integer bcId;

    private String bcName;

    private Date createTime;

    private Date updateTime;

    private Integer viewCount;

    private Integer upCount;

    private Integer replyCount;

    private Boolean userUpStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBcId() {
        return bcId;
    }

    public void setBcId(Integer bcId) {
        this.bcId = bcId;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
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

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }


    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public Boolean getUserUpStatus() {
        return userUpStatus;
    }

    public void setUserUpStatus(Boolean userUpStatus) {
        this.userUpStatus = userUpStatus;
    }

    @Override
    public String toString() {
        return "BlogDetailVO{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", tags='" + tags + '\'' +
                ", bcId=" + bcId +
                ", bcName='" + bcName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", viewCount=" + viewCount +
                ", upCount=" + upCount +
                ", replyCount=" + replyCount +
                ", userUpStatus=" + userUpStatus +
                '}';
    }
}
