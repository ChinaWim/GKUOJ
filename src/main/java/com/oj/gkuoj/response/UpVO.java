package com.oj.gkuoj.response;

/**
 * @author m969130721@163.com
 * @date 19-1-31 上午12:30
 */
public class UpVO {

    private Boolean status;

    private Integer count;

    public UpVO(Boolean status ,Integer count){
        this.status = status;
        this.count = count;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UpVO{" +
                "status=" + status +
                ", count=" + count +
                '}';
    }
}
