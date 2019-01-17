package com.oj.gkuoj.service;

import com.oj.gkuoj.response.RestResponseVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author m969130721@163.com
 * @date 19-1-17 下午1:30
 */
public interface FileService {

    RestResponseVO upload(MultipartFile multipartFile);


}
