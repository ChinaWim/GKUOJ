package com.oj.gkuoj.response;

import com.oj.gkuoj.entity.Tag;

import java.io.Serializable;
import java.util.List;

/**
 * 顶级Tag
 * @author m969130721@163.com
 * @date 19-2-13 下午10:33
 */
public class TagVO implements Serializable {

    private Integer id;

    private Integer parentTag;

    private Integer parentId;

    private String name;

    private List<Tag> tagList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public Integer getParentTag() {
        return parentTag;
    }

    public void setParentTag(Integer parentTag) {
        this.parentTag = parentTag;
    }

    @Override
    public String toString() {
        return "TagVO{" +
                "id=" + id +
                ", parentTag=" + parentTag +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", tagList=" + tagList +
                '}';
    }
}
