package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.response.TestcaseVO;
import com.oj.gkuoj.service.FileService;
import com.oj.gkuoj.utils.UUIDUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author m969130721@163.com
 * @date 19-1-17 下午1:31
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.server.http.prefix}")
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
    public RestResponseVO uploadImageByMD(MultipartFile multipartFile, String guid, String username) {
        if (!StringUtils.isNoneBlank(username, guid) || multipartFile == null || multipartFile.isEmpty()) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        String originalFilename = multipartFile.getOriginalFilename();
        try {
            String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            List<String> typeArray = Arrays.asList(fileServerTypeImage.split(","));
            if (!typeArray.contains(type)) {
                logger.info("不支持此图片文件格式,{}", type);
                return RestResponseVO.createByErrorEnum(RestResponseEnum.FILE_TYPE_ERROR);
            }
            String newUri = username + "/blog/" + guid + "." + type;
            String savePath = fileServerImageDir + "/" + newUri;
            String url = fileServerHttpPrefix + "image/" + newUri;

            File saveFile = new File(savePath);
            File parentFile = saveFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
                if (!parentFile.canWrite()) {
                    logger.info("文件{},没有操作权限", savePath);
                    return RestResponseVO.createByErrorEnum(RestResponseEnum.FILE_PERMISSION_ERROR);
                }
            }

            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), saveFile);

            return RestResponseVO.createBySuccess(url);
        } catch (Exception e) {
            logger.info("文件IO异常", e.getMessage());
            return RestResponseVO.createByErrorMessage(e.getMessage());
        }
    }

    @Override
    public RestResponseVO<String> uploadImage(MultipartFile multipartFile, String username) {
        if (!StringUtils.isNoneBlank(username) || multipartFile == null || multipartFile.isEmpty()) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        String originalFilename = multipartFile.getOriginalFilename();
        try {
            String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            List<String> typeArray = Arrays.asList(fileServerTypeImage.split(","));
            if (!typeArray.contains(type)) {
                logger.info("不支持此图片文件格式,{}", type);
                return RestResponseVO.createByErrorEnum(RestResponseEnum.FILE_TYPE_ERROR);
            }
            String newImageName = UUIDUtil.createByAPI36();
            String newUri = username + "/" + newImageName + "." + type;
            String savePath = fileServerImageDir + "/" + newUri;
            String url = fileServerHttpPrefix + "image/" + newUri;

            File saveFile = new File(savePath);
            File parentFile = saveFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
                if (!parentFile.canWrite()) {
                    logger.info("文件{},没有操作权限", savePath);
                    return RestResponseVO.createByErrorEnum(RestResponseEnum.FILE_PERMISSION_ERROR);
                }
            }
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), saveFile);
            return RestResponseVO.createBySuccess(url);
        } catch (Exception e) {
            logger.info("文件IO异常", e.getMessage());
            return RestResponseVO.createByErrorMessage(e.getMessage());
        }
    }

    @Override
    public RestResponseVO<byte[]> get(String path) {
        if (StringUtils.isBlank(path)) {
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

    @Override
    public void getTestcaseInput(HttpServletResponse response, Integer problemId, Integer num) {
        String fileName = num + ".in";
        String filePath = fileServerTestcaseDir + "/" +problemId+ "/input/" +num + ".txt";
        downloadFile2Browser(response, filePath, fileName);
    }


    @Override
    public void getTestcaseOutput(HttpServletResponse response, Integer problemId, Integer num) {
        String fileName = num + ".out";
        String filePath = fileServerTestcaseDir + "/" +problemId+ "/output/" +num + ".txt";
        downloadFile2Browser(response, filePath, fileName);
    }

    @Override
    public RestResponseVO<String> deleteTestcase(Integer problemId) {
        if (problemId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        String problemDir = fileServerTestcaseDir + "/" + problemId;
        try {
            FileUtils.deleteDirectory(new File(problemDir));
        } catch (IOException e) {
            logger.error("找不到此文件{},删除测试用例失败", problemDir);
            return RestResponseVO.createByErrorEnum(RestResponseEnum.FILE_NOT_FOUND_ERROR);
        }
        return RestResponseVO.createBySuccess();
    }

    @Override
    public RestResponseVO<String> saveTestcase(Integer problemId,Integer num,String testcaseInput, String testcaseOutput) {
        if (problemId == null || !StringUtils.isNoneBlank(testcaseInput, testcaseOutput)) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }

        String problemDir = fileServerTestcaseDir +"/"+problemId;

        if (num == null) {
            File oldInputDir = new File(problemDir+"/input");
            if (oldInputDir.exists() && oldInputDir.isDirectory()) {
                File[] subFiles = oldInputDir.listFiles();
                if (ArrayUtils.isNotEmpty(subFiles)) {
                    num = subFiles.length + 1;
                }else{
                    num = 1;
                }
            }else {
                num = 1;
            }
        }

        String testcaseInputFilePath = problemDir + "/input/" + num + ".txt";
        String testcaseOutputFilePath = problemDir + "/output/" + num + ".txt";
        File oldTestcaseInputFile = new File(testcaseInputFilePath);
        File oldTestcaseOutputFile = new File(testcaseOutputFilePath);
        oldTestcaseInputFile.deleteOnExit();
        oldTestcaseOutputFile.deleteOnExit();
        try {
            FileUtils.writeStringToFile(new File(testcaseInputFilePath),testcaseInput,StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(new File(testcaseOutputFilePath),testcaseOutput,StandardCharsets.UTF_8);
        } catch (IOException e) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.ORIGINAL_PASSWORD_ERROR);
        }
        return RestResponseVO.createBySuccess();
    }
    @Override
    public RestResponseVO<TreeSet<TestcaseVO>> listTestcaseVO(Integer problemId) {
        TreeSet<TestcaseVO> testcaseVOList = new TreeSet<>(Comparator.comparing(TestcaseVO::getNum));

        if(problemId == null){
            return RestResponseVO.createBySuccess(testcaseVOList);
        }
        String problemDir = fileServerTestcaseDir + "/" + problemId;
        String testcaseInputDir = problemDir + "/input";
        String testcaseOutputDir = problemDir + "/output";

        File testcaseInputFile = new File(testcaseInputDir);
        File testcaseOutputFile = new File(testcaseOutputDir);

        if (testcaseInputFile.exists() && testcaseInputFile.isDirectory()
                && testcaseOutputFile.exists() && testcaseOutputFile.isDirectory()) {
            File[] subInputFile = testcaseInputFile.listFiles();
            File[] subOutputFile = testcaseOutputFile.listFiles();

            if (ArrayUtils.isEmpty(subInputFile) || ArrayUtils.isEmpty(subOutputFile) || subInputFile.length != subOutputFile.length) {
                return RestResponseVO.createBySuccess(testcaseVOList);
            }

            for (File file : subInputFile) {
                TestcaseVO testcaseVO = new TestcaseVO();
                String inputFileName = file.getName();
                String num = inputFileName.substring(0, inputFileName.lastIndexOf("."));
                String input = null;
                try {
                    input = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                } catch (IOException e) {
                    input = "";
                }
                String output = null;
                try {
                    String testcaseOutputNumFilePath = testcaseOutputDir + "/" + num + ".txt";
                    File testcaseOutputNumFile = new File(testcaseOutputNumFilePath);
                    output = FileUtils.readFileToString(testcaseOutputNumFile, StandardCharsets.UTF_8);
                } catch (IOException e) {
                    output = "";
                }

                testcaseVO.setNum(Integer.parseInt(num));
                testcaseVO.setInput(input);
                testcaseVO.setOutput(output);

                testcaseVOList.add(testcaseVO);
            }
        }

        return RestResponseVO.createBySuccess(testcaseVOList);
    }

    @Override
    public RestResponseVO deleteTestcase(Integer problemId, Integer num) {
        String problemDir = fileServerTestcaseDir + "/" + problemId;
        String testcaseInputPath = problemDir + "/input/" + num + ".txt";
        String testcaseOutputPath = problemDir + "/output/" + num + ".txt";
        File testcaseInputFile = new File(testcaseInputPath);
        File testcaseOutputFile = new File(testcaseOutputPath);
        boolean isDelete = false;
        isDelete = testcaseInputFile.delete();
        if (isDelete) {
            isDelete = testcaseOutputFile.delete();
        }
        return isDelete ?
                RestResponseVO.createBySuccess(StringConst.DEL_SUCCESS) : RestResponseVO.createBySuccess(StringConst.DEL_FAIL);
    }


    private void downloadFile2Browser(HttpServletResponse response, String filePath, String fileName) {
        if (fileName == null || "".equals(fileName)) {
            File file = new File(filePath);
            fileName = file.getName();
        }
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
