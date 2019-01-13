package com.oj.gkuoj.entity;

import java.io.Serializable;
import java.util.Date;

public class Up implements Serializable {

    private static final long serialVersionUID = 4799170065386693202L;

    private Integer id;

    private Integer typeId;

    private Integer type;

    private Integer userId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Up(Integer id, Integer typeId, Integer type, Integer userId, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.typeId = typeId;
        this.type = type;
        this.userId = userId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Up() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "Up{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", type=" + type +
                ", userId=" + userId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}