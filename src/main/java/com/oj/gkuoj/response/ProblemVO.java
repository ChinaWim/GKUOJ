package com.oj.gkuoj.response;

/**
 * @author m969130721@163.com
 * @date 19-2-1 下午4:08
 */

import java.io.Serializable;
import java.util.Date;

public class ProblemVO implements Serializable{

    private static final long serialVersionUID = -1224668082268614715L;

    private Integer id;

    private String name;

    private String tags;

    private Integer level;

    private Integer submitCount;

    private Integer acCount;

    private Integer waCount;

    private Integer flag;

    private Date createTime;

    private Date updateTime;

    /**
     * 1正在尝试　2通过
     */
    private Integer userStatus;

    public ProblemVO(Integer id, String name, String tags, Integer level, Integer submitCount, Integer acCount, Integer waCount, Integer flag, Date createTime, Date updateTime, Integer userStatus) {
        this.id = id;
        this.name = name;
        this.tags = tags;
        this.level = level;
        this.submitCount = submitCount;
        this.acCount = acCount;
        this.waCount = waCount;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userStatus = userStatus;
    }

    public ProblemVO() {
        super();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSubmitCount() {
        return submitCount;
    }

    public void setSubmitCount(Integer submitCount) {
        this.submitCount = submitCount;
    }

    public Integer getAcCount() {
        return acCount;
    }

    public void setAcCount(Integer acCount) {
        this.acCount = acCount;
    }


    public Integer getWaCount() {
        return waCount;
    }

    public void setWaCount(Integer waCount) {
        this.waCount = waCount;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ProblemVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags='" + tags + '\'' +
                ", level=" + level +
                ", submitCount=" + submitCount +
                ", acCount=" + acCount +
                ", waCount=" + waCount +
                ", flag=" + flag +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userStatus=" + userStatus +
                '}';
    }
}