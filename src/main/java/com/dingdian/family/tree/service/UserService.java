package com.dingdian.family.tree.service;

import com.dingdian.family.tree.pojo.vo.ReturnData;

public interface UserService {
    ReturnData saveNewUser(String cre_family_tree,String family_id,String tree_id,String openid,String nickname,String iconUrl);
}
