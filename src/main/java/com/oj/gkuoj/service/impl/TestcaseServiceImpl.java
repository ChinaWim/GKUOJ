package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.entity.Tag;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.response.TagVO;
import com.oj.gkuoj.service.TestcaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午4:28
 */
@Slf4j
@Service
public class TestcaseServiceImpl implements TestcaseService {


    /**
     * todo 超链接
     * @param problemId
     * @return
     */
    @Override
    public RestResponseVO listTestcaseByProblemId(Integer problemId) {
        if (problemId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        return null;
    }



}
