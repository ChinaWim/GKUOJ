package com.oj.gkuoj.rest.common;

import com.oj.gkuoj.response.RestResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author m969130721@163.com
 * @date 19-1-17 下午1:24
 */
@RestController
@RequestMapping("/file")
public class FileController {



    @RequestMapping("/upload")
    public RestResponseVO upload(MultipartFile multipartFile) {
        if(multipartFile == null || multipartFile.isEmpty()){
            return RestResponseVO.createByErrorMessage("上传文件不能空");

        }

        return null;









    }

}
