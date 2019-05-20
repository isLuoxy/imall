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
public class PmsProductAttributeValue {


    private Long id;

    /** 商品 id*/
    private Long productId;

    /** 具体商品 sku 名称，读取时拼接在商品总名称后面形成新名称*/
    private String productName;

    /** 商品属性值，用逗号分割*/
    private String productAttributeValue;

    /** 该商品对应的价格 */
    private BigDecimal price;

    /** 该商品对应的库存 */
    private Integer stock;


    /** 商品sn */
    private Long productSn;

    /**
     * 商品库存减少的值，不接收数据库的值
     */
    private Integer difference;


}
