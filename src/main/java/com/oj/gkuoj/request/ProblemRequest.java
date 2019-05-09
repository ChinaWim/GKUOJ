package com.oj.gkuoj.request;

import com.oj.gkuoj.response.TestcaseVO;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-5-8 下午5:45
 */
@Data
public class ProblemRequest {

    private Integer id;

    private String name;

    private String content;

    private String htmlContent;

    private String inputDesc;

    private String outputDesc;

    private String testcaseInput;

    private String testcaseOutput;

    private Integer level;

    private Long time;

    private Long memory;

    private Integer flag;

    private String tags;

    private List<TestcaseVO> testcaseList;

    private boolean settingUpdated = false;


}
