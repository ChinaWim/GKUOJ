package com.oj.gkuoj.service;

import com.oj.gkuoj.response.RestResponseVO;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午4:28
 */
public interface TestcaseService {

     RestResponseVO listTestcaseByProblemId(Integer problemId);


}
