package com.oj.gkuoj.service;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.ProblemCategory;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午3:41
 */

public interface ProblemCategoryService {

     ServerResponse<List<ProblemCategory>> listAll();

     ServerResponse insert(ProblemCategory problemCategory);

     ServerResponse delById(Integer id);

     ServerResponse update(ProblemCategory problemCategory);

}
