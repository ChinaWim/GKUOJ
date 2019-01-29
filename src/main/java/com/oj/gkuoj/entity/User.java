package com.oj.gkuoj.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User implements Serializable,UserDetails {

    private static final long serialVersionUID = -3145390293109713500L;

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

    private Date lastLoginTime;

    private Date createTime;

    private Date updateTime;

    private List<Role> roleList;


    public User(Integer id, String username, String password, String name, String mood, String avatar, Integer flag, String sex, String email, String phone, String school, Integer signCount, Integer submitCount, Integer solutionCount, Integer acCount, Integer tleCount, Integer peCount, Integer meCount, Integer ceCount, Integer reCount, Integer waCount, Integer goldCount, Date lastLoginTime, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.mood = mood;
        this.avatar = avatar;
        this.flag = flag;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.school = school;
        this.signCount = signCount;
        this.submitCount = submitCount;
        this.solutionCount = solutionCount;
        this.acCount = acCount;
        this.tleCount = tleCount;
        this.peCount = peCount;
        this.meCount = meCount;
        this.ceCount = ceCount;
        this.reCount = reCount;
        this.waCount = waCount;
        this.goldCount = goldCount;
        this.lastLoginTime = lastLoginTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return flag == 0;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        for (Role role : this.roleList) {
            list.add(new SimpleGrantedAuthority(role.getName()));
        }
        return list;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood == null ? null : mood.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
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

    @Override
    public String toString() {
        return "User{" +
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
                ", lastLoginTime=" + lastLoginTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", roleList=" + roleList +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (mood != null ? !mood.equals(user.mood) : user.mood != null) return false;
        if (avatar != null ? !avatar.equals(user.avatar) : user.avatar != null) return false;
        if (flag != null ? !flag.equals(user.flag) : user.flag != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (school != null ? !school.equals(user.school) : user.school != null) return false;
        if (signCount != null ? !signCount.equals(user.signCount) : user.signCount != null) return false;
        if (submitCount != null ? !submitCount.equals(user.submitCount) : user.submitCount != null) return false;
        if (solutionCount != null ? !solutionCount.equals(user.solutionCount) : user.solutionCount != null)
            return false;
        if (acCount != null ? !acCount.equals(user.acCount) : user.acCount != null) return false;
        if (tleCount != null ? !tleCount.equals(user.tleCount) : user.tleCount != null) return false;
        if (peCount != null ? !peCount.equals(user.peCount) : user.peCount != null) return false;
        if (meCount != null ? !meCount.equals(user.meCount) : user.meCount != null) return false;
        if (ceCount != null ? !ceCount.equals(user.ceCount) : user.ceCount != null) return false;
        if (reCount != null ? !reCount.equals(user.reCount) : user.reCount != null) return false;
        if (waCount != null ? !waCount.equals(user.waCount) : user.waCount != null) return false;
        if (goldCount != null ? !goldCount.equals(user.goldCount) : user.goldCount != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(user.lastLoginTime) : user.lastLoginTime != null)
            return false;
        if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(user.updateTime) : user.updateTime != null) return false;
        return roleList != null ? roleList.equals(user.roleList) : user.roleList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mood != null ? mood.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (signCount != null ? signCount.hashCode() : 0);
        result = 31 * result + (submitCount != null ? submitCount.hashCode() : 0);
        result = 31 * result + (solutionCount != null ? solutionCount.hashCode() : 0);
        result = 31 * result + (acCount != null ? acCount.hashCode() : 0);
        result = 31 * result + (tleCount != null ? tleCount.hashCode() : 0);
        result = 31 * result + (peCount != null ? peCount.hashCode() : 0);
        result = 31 * result + (meCount != null ? meCount.hashCode() : 0);
        result = 31 * result + (ceCount != null ? ceCount.hashCode() : 0);
        result = 31 * result + (reCount != null ? reCount.hashCode() : 0);
        result = 31 * result + (waCount != null ? waCount.hashCode() : 0);
        result = 31 * result + (goldCount != null ? goldCount.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (roleList != null ? roleList.hashCode() : 0);
        return result;
    }
}