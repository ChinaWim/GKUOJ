package com.oj.gkuoj.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 19-2-16 下午5:06
 */
public class RegisterVO implements Serializable {

    private static final long serialVersionUID = 8556832097454926226L;

    private Integer id;

    private Integer userId;

    private String name;

    private String school;

    private Integer compId;

    private Integer solutionCount;

    private Integer submitCount;

    private Integer score;

    private Date createTime;

    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        this.name = name;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getSolutionCount() {
        return solutionCount;
    }

    public void setSolutionCount(Integer solutionCount) {
        this.solutionCount = solutionCount;
    }

    public Integer getSubmitCount() {
        return submitCount;
    }

    public void setSubmitCount(Integer submitCount) {
        this.submitCount = submitCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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


    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "RegisterVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", compId=" + compId +
                ", solutionCount=" + solutionCount +
                ", submitCount=" + submitCount +
                ", score=" + score +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
