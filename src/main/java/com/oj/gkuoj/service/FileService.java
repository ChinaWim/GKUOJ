package com.oj.gkuoj.service;

import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.response.TestcaseVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.TreeSet;

/**
 * @author m969130721@163.com
 * @date 19-1-17 下午1:30
 */
public interface FileService {

    RestResponseVO uploadImageByMD(MultipartFile multipartFile,String guid,String username);

    RestResponseVO<String> uploadImage(MultipartFile multipartFile,String username);

    RestResponseVO<byte[]> get(String path);

    void getTestcaseInput(HttpServletResponse response,Integer problemId, Integer num);

    void getTestcaseOutput(HttpServletResponse response, Integer problemId, Integer num);

    RestResponseVO<String> deleteTestcase(Integer problemId);

    RestResponseVO<String> saveTestcase(Integer problemId,Integer num,String testcaseInput, String testcaseOutput);

    RestResponseVO<TreeSet<TestcaseVO>> listTestcaseVO(Integer problemId);

    RestResponseVO deleteTestcase(Integer problemId, Integer num);
}
