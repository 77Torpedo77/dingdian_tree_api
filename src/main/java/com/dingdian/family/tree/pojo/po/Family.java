package com.dingdian.family.tree.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Family {
    private String familyId;
    private String treeId;
    private String familyMember;
    private Integer familyExp;
}