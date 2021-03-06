package com.dingdian.family.tree.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {
    private String authorOpenid;
    private String treeId;
    private String familyId;
    private String content;
    private String paperId;//存的时候不传，数据库自增，取的时候才取
}