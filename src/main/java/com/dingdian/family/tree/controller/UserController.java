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
    public ReturnData saveNewUser(String cre_family_tree,String family_id,String tree_id,String openid,String nickname,String iconUrl)
    {
        return UserService.saveNewUser(cre_family_tree,family_id,tree_id,openid,nickname,iconUrl);
    }

    @ResponseBody
    @PostMapping("/getUserInfo")
    public ReturnData getUserInfo(String openid)
    {
        return UserService.getUserInfo(openid);
    }

    @ResponseBody
    @PostMapping("/savePaper")
    public ReturnData savePaper(String openid, String family_id, String tree_id, String content)
    {
        return UserService.savePaper(openid,family_id,tree_id,content);
    }

    @ResponseBody
    @PostMapping("/getPaper")
    public ReturnData getPaper(String tree_id)
    {
        return UserService.getPaper(tree_id);
    }

    @ResponseBody
    @PostMapping("/saveComment")
    public ReturnData saveComment(String author_openid,String paper_id,String content)
    {
        return UserService.saveComment(author_openid,paper_id,content);
    }

    @ResponseBody
    @PostMapping("/getComment")
    public ReturnData getComment(String paper_id)
    {
        return UserService.getComment(paper_id);
    }

    @ResponseBody
    @PostMapping("/updateAllExp")
    public ReturnData updateAllExp(Integer add_exp, String openid)
    {
        return UserService.updateAllExp(add_exp,openid);
    }
}
