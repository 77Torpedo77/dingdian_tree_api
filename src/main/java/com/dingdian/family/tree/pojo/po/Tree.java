package com.dingdian.family.tree.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
    private String treeId;
    private String treeMember;
    private Integer treeExp;
}