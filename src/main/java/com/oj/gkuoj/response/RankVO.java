package com.oj.gkuoj.response;

import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 19-2-2 下午4:23
 */
public class RankVO {

    private Integer id;

    private String name;

    private String mood;

    private String avatar;

    private Integer signCount;

    private Integer submitCount;

    private Integer solutionCount;

    private Integer acCount;

    private Integer goldCount;

    private Integer rating;

    private Integer rank;

    private Date lastLoginTime;

    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }

    public Integer getSubmitCount() {
        return submitCount;
    }

    public void setSubmitCount(Integer submitCount) {
        this.submitCount = submitCount;
    }

    public Integer getSolutionCount() {
        return solutionCount;
    }

    public void setSolutionCount(Integer solutionCount) {
        this.solutionCount = solutionCount;
    }

    public Integer getAcCount() {
        return acCount;
    }

    public void setAcCount(Integer acCount) {
        this.acCount = acCount;
    }

    public Integer getGoldCount() {
        return goldCount;
    }

    public void setGoldCount(Integer goldCount) {
        this.goldCount = goldCount;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "RankVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mood='" + mood + '\'' +
                ", avatar='" + avatar + '\'' +
                ", signCount=" + signCount +
                ", submitCount=" + submitCount +
                ", solutionCount=" + solutionCount +
                ", acCount=" + acCount +
                ", goldCount=" + goldCount +
                ", rating=" + rating +
                ", rank=" + rank +
                ", lastLoginTime=" + lastLoginTime +
                ", createTime=" + createTime +
                '}';
    }
}
