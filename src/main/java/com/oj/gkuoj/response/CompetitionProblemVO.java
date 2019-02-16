package com.oj.gkuoj.response;

import com.oj.gkuoj.entity.Problem;

import java.io.Serializable;
import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 19-2-16 下午3:08
 */
public class CompetitionProblemVO implements Serializable {

    private static final long serialVersionUID = 8560252327954434308L;

    private Integer id;

    private Integer compId;

    private Integer score;

    private Integer problemId;

    private String problemName;

    private Integer submitCount;

    private Integer acCount;

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

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
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
}
