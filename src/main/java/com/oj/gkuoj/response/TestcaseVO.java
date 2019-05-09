package com.oj.gkuoj.response;

/**
 * @author m969130721@163.com
 * @date 19-5-4 下午11:42
 */
public class TestcaseVO {

    private Integer num;

    private String input;

    private String output;

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
                ", num=" + num +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestcaseVO that = (TestcaseVO) o;

        return num != null ? num.equals(that.num) : that.num == null;
    }

    @Override
    public int hashCode() {
        return num != null ? num.hashCode() : 0;
    }
}
