package com.oj.gkuoj.response;

import com.oj.gkuoj.entity.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-3-17 下午2:30
 */
public class UserDetailVO implements Serializable {

    private static final long serialVersionUID = -2154415380064949390L;

    private Integer id;

    private String username;

    private String password;

    private String name;

    private String mood;

    private String avatar;

    private Integer flag;

    private String sex;

    private String email;

    private String phone;

    private String school;

    private Integer signCount;

    private Integer submitCount;

    private Integer solutionCount;

    private Integer acCount;

    private Integer tleCount;

    private Integer peCount;

    private Integer meCount;

    private Integer ceCount;

    private Integer reCount;

    private Integer waCount;

    private Integer goldCount;

    private Integer rating;

    private Date lastLoginTime;

    private Date createTime;

    private Date updateTime;

    private List<Role> roleList = new ArrayList<>();

    private String roleIds;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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

    public Integer getTleCount() {
        return tleCount;
    }

    public void setTleCount(Integer tleCount) {
        this.tleCount = tleCount;
    }

    public Integer getPeCount() {
        return peCount;
    }

    public void setPeCount(Integer peCount) {
        this.peCount = peCount;
    }

    public Integer getMeCount() {
        return meCount;
    }

    public void setMeCount(Integer meCount) {
        this.meCount = meCount;
    }

    public Integer getCeCount() {
        return ceCount;
    }

    public void setCeCount(Integer ceCount) {
        this.ceCount = ceCount;
    }

    public Integer getReCount() {
        return reCount;
    }

    public void setReCount(Integer reCount) {
        this.reCount = reCount;
    }

    public Integer getWaCount() {
        return waCount;
    }

    public void setWaCount(Integer waCount) {
        this.waCount = waCount;
    }

    public Integer getGoldCount() {
        return goldCount;
    }

    public void setGoldCount(Integer goldCount) {
        this.goldCount = goldCount;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "UserDetailVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", mood='" + mood + '\'' +
                ", avatar='" + avatar + '\'' +
                ", flag=" + flag +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", school='" + school + '\'' +
                ", signCount=" + signCount +
                ", submitCount=" + submitCount +
                ", solutionCount=" + solutionCount +
                ", acCount=" + acCount +
                ", tleCount=" + tleCount +
                ", peCount=" + peCount +
                ", meCount=" + meCount +
                ", ceCount=" + ceCount +
                ", reCount=" + reCount +
                ", waCount=" + waCount +
                ", goldCount=" + goldCount +
                ", rating=" + rating +
                ", lastLoginTime=" + lastLoginTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", roleList=" + roleList +
                ", roleIds='" + roleIds + '\'' +
                '}';
    }
}
