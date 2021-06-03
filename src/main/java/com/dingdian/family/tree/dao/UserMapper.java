package com.dingdian.family.tree.dao;

import com.dingdian.family.tree.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    void saveNewUser(User auser);
}
