package com.oj.gkuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.dao.TagMapper;
import com.oj.gkuoj.entity.Tag;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.response.TagVO;
import com.oj.gkuoj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午3:43
 */
@Service
public class TagImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public RestResponseVO<List<TagVO>> listParentVOAll() {
        List<TagVO> problemCategoryList = tagMapper.listParentVOAll();
        return RestResponseVO.createBySuccess(problemCategoryList);
    }

    @Override
    public RestResponseVO insert(Tag tag) {
        if (tag == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = tagMapper.insertSelective(tag);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = tagMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO updateById(Tag tag) {
        if (tag == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = tagMapper.updateByPrimaryKeySelective(tag);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO getById(Integer tagId) {
        if (tagId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        return RestResponseVO.createBySuccess(tagMapper.selectByPrimaryKey(tagId));
    }

    @Override
    public RestResponseVO list2Page(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Tag> tagList = tagMapper.list2Page(keyword);
        PageInfo<Tag> pageInfo = new PageInfo<>(tagList);
        return RestResponseVO.createBySuccess(pageInfo);
    }
}
