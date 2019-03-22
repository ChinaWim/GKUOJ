package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.Tag;
import com.oj.gkuoj.response.TagVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<TagVO> listParentVOAll();

    List<Tag> list2Page(@Param("keyword") String keyword);
}