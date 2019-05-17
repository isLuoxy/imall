package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 产品详情 sku 基本类
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsProductAttibuteValue {


    private Long id;

    /** 商品 id*/
    private Long productId;

    /** 商品属性 id，用逗号分割*/
    private String productAttributeId;

    /** 商品属性名称，用逗号分割 */
    private String productAttributeName;

    /** 商品属性值，用逗号分割*/
    private String productAttributeValue;

    /** 该商品对应的价格 */
    private BigDecimal price;

    /** 该商品对应的库存 */
    private Integer stock;

    /** 用于接收减库存的值 ，不接受数据库的值*/
    //private Integer difference;


}
