package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author m969130721@163.com
 * @date 19-1-17 下午1:31
 */
public class FileServiceImpl implements FileService {

    @Value("${file.server.http.prefix")
    private String fileServerHttpPrefix;

    @Value("${file.server.dir}")
    private String fileServerDir;

    @Value("${file.server.image.dir}")
    private String fileServerImageDir;

    @Value("${file.server.testcase.dir}")
    private String fileServerTestcaseDir;

    @Override
    public RestResponseVO upload(MultipartFile multipartFile) {




        return null;
    }
}
