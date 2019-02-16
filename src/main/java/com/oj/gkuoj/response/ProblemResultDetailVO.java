package com.oj.gkuoj.response;

import com.oj.gkuoj.entity.TestcaseResult;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-2-15 上午2:16
 */
public class ProblemResultDetailVO implements Serializable {

    private static final long serialVersionUID = -1187644164956054559L;

    private Integer id;

    private Integer userId;

    private String avatar;

    private String name;

    private Integer problemId;

    private String problemName;

    private Integer compId;

    private String runNum;

    private Integer status;

    private String type;

    private Long time;

    private Long memory;

    private String errorMsg;

    private String sourceCode;

    private Date createTime;

    private Date updateTime;

    private List<TestcaseResult> testcaseResultList;

    private Integer acCount = 0;

    private Integer score = 0;


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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getRunNum() {
        return runNum;
    }

    public void setRunNum(String runNum) {
        this.runNum = runNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
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

    public List<TestcaseResult> getTestcaseResultList() {
        return testcaseResultList;
    }

    public void setTestcaseResultList(List<TestcaseResult> testcaseResultList) {
        this.testcaseResultList = testcaseResultList;
    }

    public Integer getAcCount() {
        return acCount;
    }

    public void setAcCount(Integer acCount) {
        this.acCount = acCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ProblemResultDetailVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", problemId=" + problemId +
                ", problemName='" + problemName + '\'' +
                ", compId=" + compId +
                ", runNum='" + runNum + '\'' +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", memory=" + memory +
                ", errorMsg='" + errorMsg + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", testcaseResultList=" + testcaseResultList +
                ", acCount=" + acCount +
                ", score=" + score +
                '}';
    }
}
