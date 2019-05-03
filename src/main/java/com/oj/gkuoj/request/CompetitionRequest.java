package com.oj.gkuoj.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 19-4-22 上午1:12
 */
@Data
public class CompetitionRequest {

    private Integer id;

    private Integer userId;

    private String name;

    private String title;

    private String content;

    private String htmlContent;

    private String password;

    @DateTimeFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private Date endTime;

}
