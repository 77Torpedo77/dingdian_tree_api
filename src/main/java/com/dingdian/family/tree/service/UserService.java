package com.dingdian.family.tree.service;

import com.dingdian.family.tree.pojo.vo.ReturnData;

public interface UserService {
    ReturnData saveNewUser(String cre_family_tree,String family_id,String tree_id,String openid,String nickname,String iconUrl);
    ReturnData getUserInfo(String openid);
    ReturnData savePaper(String openid, String family_id, String tree_id, String content);
    ReturnData getPaper(String tree_id);
    ReturnData saveComment(String author_openid,String paper_id,String content);
    ReturnData getComment(String paper_id);
    ReturnData updateAllExp(Integer add_exp, String openid);
    ReturnData getAllUser(String tree_id);
    ReturnData getAllFamily(String tree_id);
}
