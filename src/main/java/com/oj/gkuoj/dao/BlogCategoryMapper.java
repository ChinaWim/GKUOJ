package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.BlogCategory;

public interface BlogCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    BlogCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogCategory record);

    int updateByPrimaryKey(BlogCategory record);
}