package com.oj.gkuoj.service;

import com.oj.gkuoj.entity.Tag;
import com.oj.gkuoj.response.ServerResponseVO;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午3:41
 */

public interface TagService {

     ServerResponseVO<List<Tag>> listAll();

     ServerResponseVO insert(Tag tag);

     ServerResponseVO delById(Integer id);

     ServerResponseVO update(Tag tag);


}
