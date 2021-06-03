package com.dingdian.family.tree.dao;

import com.dingdian.family.tree.pojo.po.Paper;
import com.dingdian.family.tree.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    void saveNewUser(User auser);
    User getUserInfo(String openid);
    void savePaper(Paper paper);
    Paper getPaper(String tree_id);
}
