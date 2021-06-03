package com.dingdian.family.tree.service.impl;

import com.dingdian.family.tree.dao.UserMapper;
import com.dingdian.family.tree.pojo.po.User;
import com.dingdian.family.tree.pojo.vo.ReturnData;
import com.dingdian.family.tree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TestService")
public class UserServicelmpl implements UserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public ReturnData saveNewUser(String openid, String family_id, String tree_id, Integer exp)
    {
        if (openid == null || family_id == null || tree_id == null || exp == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        User user = new User();
        user.setOpenid(openid);
        user.setFamilyId(family_id);
        user.setTreeId(tree_id);
        user.setExp(exp);
        UserMapper.saveNewUser(user);
        return ReturnData.success("我是你爹");
    }
}
