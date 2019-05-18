package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 简略商品分类 用于展示显示
 * @author L99
 * @createDate 2019/5/17
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefClassification {

    /**
     * 分类 id
     */
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 下级分类列表
     */
    private List<BriefClassification> lowerClassification;
}

