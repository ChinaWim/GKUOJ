package com.oj.gkuoj.service;

import com.oj.gkuoj.entity.Tag;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.response.TagVO;

import java.util.List;

/**题目tag
 * @author m969130721@163.com
 * @date 18-12-23 下午3:41
 */

public interface TagService {

     RestResponseVO<List<TagVO>> listParentVOAll();

     RestResponseVO insert(Tag tag);

     RestResponseVO delById(Integer id);

     RestResponseVO updateById(Tag tag);

    RestResponseVO getById(Integer tagId);

    RestResponseVO list2Page(Integer pageNum, Integer pageSize, String keyword);

    RestResponseVO listAll();
}
