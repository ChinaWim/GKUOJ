package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.BlogComment;
import com.oj.gkuoj.response.BlogCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    BlogComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);

    List<BlogCommentVO> listBlogCommentVO(@Param("sort") Integer sort, @Param("blogId") Integer blogId);
}