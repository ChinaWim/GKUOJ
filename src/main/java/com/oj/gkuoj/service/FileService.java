package com.oj.gkuoj.service;

import com.oj.gkuoj.response.RestResponseVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author m969130721@163.com
 * @date 19-1-17 下午1:30
 */
public interface FileService {

    RestResponseVO uploadImageByMD(MultipartFile multipartFile,String guid,String username);


    RestResponseVO<byte[]> get(String path);

    void getTestcaseInput(HttpServletResponse response,Integer problemId, Integer num);

    void getTestcaseOutput(HttpServletResponse response, Integer problemId, Integer num);
}
