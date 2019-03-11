package com.oj.gkuoj.rest.backend;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.entity.Tag;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午4:22
 */
@Controller("backendTagController")
@RequestMapping("/backend/tag")
public class TagController {

    @Autowired
    private TagService tagService;


    /**
     * 获取标签页面
     * @param sort
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/listTag2Page")
    @ResponseBody
    public RestResponseVO listProblem(@RequestParam(defaultValue = "-1") Integer sort,
                                                @RequestParam(defaultValue = "") String keyword,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "20")Integer pageSize){
        return tagService.listParentVOAll();
    }



    /**
     * 添加tag
     * @param tag
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public RestResponseVO add(Tag tag){
        return tagService.insert(tag);
    }


    /**
     * 更新tag
     * @param tag
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public RestResponseVO update(Tag tag){
        return tagService.updateById(tag);
    }

    /**
     * 删除problem
     * @param tagId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer tagId){
        return tagService.delById(tagId);
    }



}
