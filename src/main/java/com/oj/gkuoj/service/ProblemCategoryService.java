package com.oj.gkuoj.service;

import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.ProblemCategory;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午3:41
 */

public interface ProblemCategoryService {

     ServerResponseVO<List<ProblemCategory>> listAll();

     ServerResponseVO insert(ProblemCategory problemCategory);

     ServerResponseVO delById(Integer id);

     ServerResponseVO update(ProblemCategory problemCategory);


}
