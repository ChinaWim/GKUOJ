package com.oj.gkuoj.rest.common;

import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author m969130721@163.com
 * @date 19-1-17 下午1:24
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;


    /**
     * 　MD上传图片 todo
     *
     * @param guid
     * @param multipartFile
     * @param userDetails
     * @return success  message url
     */
    @ResponseBody
    @RequestMapping(value = "/uploadImageByMD", method = RequestMethod.POST)
    public Map uploadImageByMD(String guid, @RequestParam(value = "editormd-image-file", required = false) MultipartFile multipartFile,
                           @AuthenticationPrincipal UserDetails userDetails) {
        /*if (userDetails == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }*/
        RestResponseVO restResponseVO = fileService.uploadImageByMD(multipartFile, guid,"ming");
        Map<String, Object> map = new HashMap<>();
        if (restResponseVO.isSuccess()) {
            map.put("success", 1);
            map.put("message", "上传成功");
            map.put("url", restResponseVO.getData());
        } else {
            map.put("success", 0);
            map.put("message", restResponseVO.getMsg());
        }
        return map;
    }

    @RequestMapping("/get")
    public RestResponseVO<byte[]> get(String token, String path) {
        //todo token
        if (StringUtils.isBlank(token)) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.TOKEN_ERROR);
        }
        return fileService.get(path);
    }


}
