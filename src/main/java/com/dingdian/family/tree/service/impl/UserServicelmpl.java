package com.dingdian.family.tree.service.impl;

import com.dingdian.family.tree.dao.UserMapper;
import com.dingdian.family.tree.pojo.po.*;
import com.dingdian.family.tree.pojo.vo.ReturnData;
import com.dingdian.family.tree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("UserService")
public class UserServicelmpl implements UserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public ReturnData saveNewUser(String cre_family_tree,String family_id,String tree_id,String openid,String nickname,String iconUrl)
    {
        if (cre_family_tree==null || family_id == null  ||tree_id == null  ||openid == null  || nickname == null || iconUrl == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        Family family = UserMapper.getFamily(family_id);
        Tree tree = UserMapper.getTree(tree_id);
        User user = new User();
        user.setOpenid(openid);
        user.setExp(0);
        user.setNickname(nickname);
        user.setIconUrl(iconUrl);
        user.setFamilyId(family_id);
        user.setTreeId(tree_id);

        if (cre_family_tree.equals("0"))
        {
            if (family == null)
            {
                return ReturnData.fail(40401,"没有此家庭");
            }
            if (tree == null)
            {
                return ReturnData.fail(40402,"没有此家族树");
            }
            UserMapper.saveNewUser(user);
        }
        if (cre_family_tree.equals("1"))
        {
            if (family != null)
            {
                return ReturnData.fail(60601,"此家庭号已存在");
            }
            if (tree == null)
            {
                return ReturnData.fail(40402,"没有此家族树");
            }
            UserMapper.saveNewUser(user);

            Family new_family = new Family();
            new_family.setFamilyMember("xxx");
            new_family.setFamilyId(family_id);
            new_family.setFamilyExp(0);
            new_family.setTreeId(tree_id);
            UserMapper.saveNewFamily(new_family);
        }
        if (cre_family_tree.equals("2"))
        {
            if (family != null)
            {
                return ReturnData.fail(60601,"此家庭号已存在");
            }
            if (tree != null)
            {
                return ReturnData.fail(60602,"此家族树号已存在");
            }
            UserMapper.saveNewUser(user);

            Family new_family = new Family();
            new_family.setFamilyMember("xxx");
            new_family.setFamilyId(family_id);
            new_family.setFamilyExp(0);
            new_family.setTreeId(tree_id);
            UserMapper.saveNewFamily(new_family);

            Tree new_tree = new Tree();
            new_tree.setTreeId(tree_id);
            new_tree.setTreeExp(0);
            new_tree.setTreeMember("xxx");
            UserMapper.saveNewTree(new_tree);
        }
        return ReturnData.success("新增用户成功");
    }

    public ReturnData getUserInfo(String openid)
    {
        if (openid == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        User user = UserMapper.getUserInfo(openid);
        if (user != null)
        {
            return ReturnData.success(user);
        }
        else
        {
            return  ReturnData.fail(40400,"无此用户");
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
        List<Paper> papers;
        papers = UserMapper.getPaper(tree_id);
        //需要判断列表非空，未完成##########################################################
        if (papers.get(0) != null)
        {
            return ReturnData.success(papers);
        }
        else
        {
            return  ReturnData.fail(40403,"此用户无文章");
        }
    }


    public ReturnData saveComment(String author_openid,String paper_id,String content)
    {
        if (author_openid == null || paper_id == null || content == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        Comment comment = new Comment();
        comment.setAuthorOpenid(author_openid);
        comment.setPaperId(paper_id);
        comment.setContent(content);
        UserMapper.saveComment(comment);
        return ReturnData.success("保存成功");
    }

    public ReturnData getComment(String paper_id)
    {
        if (paper_id == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        List<Comment> comments;
        comments = UserMapper.getComment(paper_id);
        //需要判断列表非空，未完成##########################################################
        if (comments.get(0) != null)
        {
            return ReturnData.success(comments);
        }
        else
        {
            return  ReturnData.fail(40404,"此文章无评论");
        }
    }

    public ReturnData updateAllExp(Integer add_exp, String openid)
    {
        if (add_exp == null || openid == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        User user = UserMapper.getUserInfo(openid);
        String family_id = user.getFamilyId();
        String tree_id = user.getTreeId();

        Family family= UserMapper.getFamily(family_id);
        Tree tree = UserMapper.getTree(tree_id);

        Integer old_exp = user.getExp();
        Integer new_exp = old_exp+add_exp;
        user.setExp(new_exp);

        old_exp = family.getFamilyExp();
        new_exp = old_exp+add_exp;
        family.setFamilyExp(new_exp);

        old_exp = tree.getTreeExp();
        new_exp = old_exp+add_exp;
        tree.setTreeExp(new_exp);

        UserMapper.updateUser(user);
        UserMapper.updateFamily(family);
        UserMapper.updateTree(tree);

        return ReturnData.success("经验更新成功");
    }

    public ReturnData getAllUser(String tree_id)
    {
        if (tree_id == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        List<User> users = UserMapper.getAllUser(tree_id);
        if (users.get(0) == null)
        {
            return ReturnData.fail(40402,"没有此家族");
        }
        return ReturnData.success(users);
    }

    public ReturnData getAllFamily(String tree_id)
    {
        if (tree_id == null)
        {
            return ReturnData.fail(40000,"某一参数为空");
        }
        List<Family> families = UserMapper.getAllFamily(tree_id);
        if (families.get(0) == null)
        {
            return ReturnData.fail(40402,"没有此家族");
        }
        return ReturnData.success(families);
    }


































}
