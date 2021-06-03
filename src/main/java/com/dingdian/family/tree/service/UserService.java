package com.dingdian.family.tree.service;

import com.dingdian.family.tree.pojo.vo.ReturnData;

public interface UserService {
    ReturnData saveNewUser(String openid, String family_id, String tree_id, Integer exp);
}
