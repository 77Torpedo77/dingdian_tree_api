package com.dingdian.family.tree.dao;

import com.dingdian.family.tree.pojo.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    void saveNewUser(User auser);
    void saveNewFamily(Family family);
    void saveNewTree(Tree tree);
    User getUserInfo(String openid);
    void savePaper(Paper paper);
    List<Paper> getPaper(String tree_id);
    void saveComment(Comment comment);
    List<Comment> getComment(String paper_id);
    Family getFamily(String family_id);
    Tree getTree(String tree_id);
    void updateUser(User user);
    void updateFamily(Family family);
    void updateTree(Tree tree);
}
