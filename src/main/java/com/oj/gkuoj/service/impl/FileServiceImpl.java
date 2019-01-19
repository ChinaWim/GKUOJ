package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.FileService;
import com.oj.gkuoj.utils.UUIDUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-1-17 下午1:31
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.server.http.prefix")
    private String fileServerHttpPrefix;

    @Value("${file.server.dir}")
    private String fileServerDir;

    @Value("${file.server.image.dir}")
    private String fileServerImageDir;

    @Value("${file.server.testcase.dir}")
    private String fileServerTestcaseDir;

    @Value("${file.server.type.image}")
    private String fileServerTypeImage;


    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public RestResponseVO uploadImage(MultipartFile multipartFile, String username) {
        if(StringUtils.isBlank(username) || multipartFile == null || multipartFile.isEmpty()){
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        String originalFilename = multipartFile.getOriginalFilename();
        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        List<String> typeArray = Arrays.asList(fileServerTypeImage.split(","));
        if (!typeArray.contains(type)) {
            logger.info("不支持此图片文件格式,{}", type);
            return RestResponseVO.createByErrorEnum(RestResponseEnum.FILE_TYPE_ERROR);
        }
        String newFileName = String.valueOf(UUIDUtil.createByTime());
        String savePath = fileServerImageDir + "/" + username + "/" + newFileName + "." + type;

        File saveFile = new File(savePath);
        File parentFile = saveFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
            if (!parentFile.canWrite()) {
                logger.info("文件{},没有操作权限", savePath);
                return RestResponseVO.createByErrorEnum(RestResponseEnum.FILE_PERMISSION_ERROR);
            }
        }
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), saveFile);
        } catch (Exception e) {
            logger.info("文件IO异常", e.getMessage());
            return RestResponseVO.createByErrorMessage(e.getMessage());
        }
        return RestResponseVO.createBySuccess();
    }

    @Override
    public RestResponseVO<byte[]> get(String path) {
        if(StringUtils.isBlank(path)){
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        String absolutePath = fileServerDir + "/" + path;
        File file = new File(absolutePath);
        try {
            byte[] fileByteArray = FileUtils.readFileToByteArray(file);
            return RestResponseVO.createBySuccess(fileByteArray);
        } catch (IOException e) {
            logger.info("获取文件异常,{}", e.getMessage());
            return RestResponseVO.createByErrorMessage(e.getMessage());
        }
    }
}
