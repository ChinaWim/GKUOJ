package com.oj.gkuoj.response;

import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 19-2-3 上午12:58
 */
public class CompetitionDetailVO {

    private Integer id;

    private Integer userId;

    private String avatar;

    private String name;

    private String competitionName;

    private String title;

    private String content;

    private Boolean secret;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;

    private Integer registerCount;

    private Integer competitionStatus;

    private boolean userRegistered;

    public CompetitionDetailVO(Integer id, Integer userId, String avatar, String name, String competitionName, String title, String content, Boolean secret, Date startTime, Date endTime, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.avatar = avatar;
        this.name = name;
        this.competitionName = competitionName;
        this.title = title;
        this.content = content;
        this.secret = secret;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CompetitionDetailVO() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName == null ? null : competitionName.trim();
    }

    public Integer getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(Integer registerCount) {
        this.registerCount = registerCount;
    }

    public Integer getCompetitionStatus() {
        return competitionStatus;
    }

    public void setCompetitionStatus(Integer competitionStatus) {
        this.competitionStatus = competitionStatus;
    }

    public Boolean getSecret() {
        return secret;
    }

    public void setSecret(Boolean secret) {
        this.secret = secret;
    }

    public boolean isUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(boolean userRegistered) {
        this.userRegistered = userRegistered;
    }

    @Override
    public String toString() {
        return "CompetitionDetailVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", secret=" + secret +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", registerCount=" + registerCount +
                ", competitionStatus=" + competitionStatus +
                ", userRegistered=" + userRegistered +
                '}';
    }
}
