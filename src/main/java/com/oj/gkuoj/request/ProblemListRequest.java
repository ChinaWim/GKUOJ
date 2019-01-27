package com.oj.gkuoj.request;

/**
 * @author m969130721@163.com
 * @date 19-1-26 下午12:19
 */
public class ProblemListRequest {
    private String keyword = "";

    private Integer level = -1;

    private String tagName = "";

    private Integer pageSize = 10;

    private Integer pageNum = 1;

    Boolean asynl = false;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Boolean getAsynl() {
        return asynl;
    }

    public void setAsynl(Boolean asynl) {
        this.asynl = asynl;
    }

    @Override
    public String toString() {
        return "ProblemListRequest{" +
                "keyword='" + keyword + '\'' +
                ", level=" + level +
                ", tagName='" + tagName + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", asynl=" + asynl +
                '}';
    }
}
