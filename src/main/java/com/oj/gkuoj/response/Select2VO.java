package com.oj.gkuoj.response;

/**
 * select2VO
 *
 * @author m969130721@163.com
 * @date 19-1-27 下午11:03
 */
public class Select2VO {

    private Integer id;

    private String text;

    private boolean selected;

    private boolean disabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "Select2VO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", selected=" + selected +
                ", disabled=" + disabled +
                '}';
    }
}
