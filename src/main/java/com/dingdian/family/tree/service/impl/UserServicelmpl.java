package com.dingdian.family.tree.service.impl;

import com.dingdian.family.tree.dao.UserMapper;
import com.dingdian.family.tree.pojo.po.Paper;
import com.dingdian.family.tree.pojo.po.User;
import com.dingdian.family.tree.pojo.vo.ReturnData;
import com.dingdian.family.tree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServicelmpl implements UserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public ReturnData saveNewUser(String openid, String family_id, String tree_id, Integer exp)
    {
        return ReturnData.success("我是你爹");
//        if (openid == null || family_id == null || tree_id == null || exp == null)
//        {
//            return ReturnData.fail(40000,"某一参数为空");
//        }
//        User user = new User();
//        user.setOpenid(openid);
//        user.setFamilyId(family_id);
//        user.setTreeId(tree_id);
//        user.setExp(exp);
//        UserMapper.saveNewUser(user);
//        return ReturnData.success("我是你爹");
    }

    public ReturnData getUserInfo(String openid)
    {
        if (openid == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        User user = new User();
        user = UserMapper.getUserInfo(openid);
        if (user.getFamilyId() != null)
        {
            return ReturnData.success(user);
        }
        else
        {
            return  ReturnData.fail(40001,"无此用户");
        }
    }

    public ReturnData savePaper(String openid, String family_id, String tree_id, String content)
    {
        if (openid == null || family_id == null || tree_id == null || content == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        Paper one_paper = new Paper();
        one_paper.setAuthorOpenid(openid);
        one_paper.setFamilyId(family_id);
        one_paper.setTreeId(tree_id);
        one_paper.setContent(content);
        UserMapper.savePaper(one_paper);
        return ReturnData.success("保存成功");
    }

    public ReturnData getPaper(String tree_id)
    {
        if (tree_id == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        Paper one_paper = new Paper();
        one_paper = UserMapper.getPaper(tree_id);
        //需要判断列表非空，未完成##########################################################
        if (one_paper.getFamilyId() != null)
        {
            return ReturnData.success(one_paper);
        }
        else
        {
            return  ReturnData.fail(40002,"此用户无文章");
        }
    }



































}
