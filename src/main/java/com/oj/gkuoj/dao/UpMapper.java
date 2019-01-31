package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.Up;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

public interface UpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Up record);

    int insertSelective(Up record);

    Up selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Up record);

    int updateByPrimaryKey(Up record);

    Up getByBlogIdUserId(@Param("blogId") Integer blogId,@Param("userId") Integer userId);

    Up getByBlogCommentIdUserId(@Param("blogCommentId") Integer blogCommentId,@Param("userId") Integer userId);

    int countBlogCommentById(Integer blogCommentId);

    int countBlogById(Integer blogId);
}