package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 简略购物车封装 用于前端显示
 * @author L99
 * @createDate 2019/5/20
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefCartItem {

    /** 该商品在购物车表中的id，用于更新商品数量和修改时间使用*/
    private Long id;

    /** 商品 sku id*/
    private Long productAttributeValueId;

    /** 商品数量 */
    private Integer quantity;

    /** 商品名称 */
    private String productName;

    /** 商品属性列表 */
    private String productAttributeValue;

    /** 商品价格 */
    private BigDecimal price;
}
