package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.BlogCategory;
import com.oj.gkuoj.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    BlogCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogCategory record);

    int updateByPrimaryKey(BlogCategory record);

    List<BlogCategory> listAll();

    List<BlogCategory> listByKeyWord(@Param("keyword") String keyword);
}