package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.entity.BlogCategory;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.response.Select2VO;
import com.oj.gkuoj.service.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-1-27 下午11:05
 */

@Controller
@RequestMapping("/blogCategory")
public class BlogCategoryController {

    @Autowired
    private BlogCategoryService blogCategoryService;

    @ResponseBody
    @RequestMapping("/listSelect2")
    public List<Select2VO> listSelect2() {
        RestResponseVO<List<BlogCategory>> responseVO = blogCategoryService.listAll();
        List<BlogCategory> data = responseVO.getData();
        List<Select2VO> select2VOList = new ArrayList<>();
        data.stream().forEach(blogCategory -> {
            Select2VO select2VO = new Select2VO();
            select2VO.setId(blogCategory.getId());
            select2VO.setText(blogCategory.getName());
            select2VOList.add(select2VO);
        });
        return select2VOList;
    }





}


