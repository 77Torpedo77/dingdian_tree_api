package com.dingdian.family.tree.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String openid;
    private String familyId;
    private String treeId;
    private Integer exp;
}
