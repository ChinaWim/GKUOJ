package com.oj.gkuoj.response;

import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 19-2-3 上午12:49
 */
public class CompetitionVO {

    private Integer id;

    private String name;

    private String title;

    private Integer registerCount;

    private Date startTime;

    private Date endTime;

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
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public Integer getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(Integer registerCount) {
        this.registerCount = registerCount;
    }

    @Override
    public String toString() {
        return "CompetitionVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", registerCount=" + registerCount +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}
