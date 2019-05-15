package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 简略商品对象 用于商品展示显示
 * @author L99
 * @createDate 2019/5/11
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefProduct {

    private Long id;

    /**
     * 商品名称
     */
    private String name;


    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 副标题
     */
    private String subTitle;

}
