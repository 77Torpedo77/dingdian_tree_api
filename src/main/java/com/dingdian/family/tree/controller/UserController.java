package com.dingdian.family.tree.controller;

import com.dingdian.family.tree.pojo.vo.ReturnData;
import com.dingdian.family.tree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService UserService;

    @ResponseBody
    @GetMapping("/tree")
    public String test()
    {
        return "我是你爹";
    }

    @ResponseBody
    @PostMapping("/saveNewUser")
    public ReturnData saveNewUser(String openid,String family_id,String tree_id,Integer exp)
    {
        return UserService.saveNewUser(openid,family_id,tree_id,exp);
    }
}
