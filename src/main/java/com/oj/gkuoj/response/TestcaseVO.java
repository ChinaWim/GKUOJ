package com.oj.gkuoj.response;

/**
 * @author m969130721@163.com
 * @date 19-5-4 下午11:42
 */
public class TestcaseVO {

    private Integer problemId;

    private Integer num;

    private String input;

    private String output;


    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "TestcaseVO{" +
                "problemId=" + problemId +
                ", num=" + num +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}
