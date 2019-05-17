package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品分类基本类
 * @author L99
 * @createDate 2019/5/8
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsProductClassification {

    private Long id;

    /** 分类名称 */
    private String name;

    /** 上级类别的 id */
    private Long parentId;

    /** 上级类别的名称*/
    private String parentName;

    /** 级别 */
    private int level;

    /** 商品数量 */
    private int productCount;

    /** 数量单位 */
    private String productUnit;

    /** 分类描述 */
    private String description;
}
