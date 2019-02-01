package com.oj.gkuoj.response;

import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 19-1-29 下午1:25
 */
public class BlogCommentVO {

    private Integer id;

    private Integer userId;

    private String avatar;

    private String name;

    private Integer blogId;

    private String content;

    private Date createTime;

    private Date updateTime;

    private Integer upCount;

    private Boolean userUpStatus;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Integer getUpCount() {
        return upCount;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public Boolean getUserUpStatus() {
        return userUpStatus;
    }

    public void setUserUpStatus(Boolean userUpStatus) {
        this.userUpStatus = userUpStatus;
    }

    @Override
    public String toString() {
        return "BlogCommentVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", blogId=" + blogId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", upCount=" + upCount +
                ", userUpStatus=" + userUpStatus +
                '}';
    }
}
