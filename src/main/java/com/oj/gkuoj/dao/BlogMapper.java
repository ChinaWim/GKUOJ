package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.response.BlogDetailVO;
import com.oj.gkuoj.response.BlogListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

    List<BlogListVO> list2BlogVO(@Param("keyword") String keyword, @Param("bcId") Integer bcId);

    BlogDetailVO getBlogDetailVO(Integer blogId);

    int updateViewCountIncrease(Integer blogId);
}