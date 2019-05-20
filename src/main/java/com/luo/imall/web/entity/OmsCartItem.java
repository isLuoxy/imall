package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车基本类
 * @author L99
 * @createDate 2019/5/14
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OmsCartItem {

    private Long id;

    /**
     * 商品 id
     */
    private Long productId;

    /**
     * 商品 sku 编码
     */
    private Long productSn;

    /**
     * 用户 id
     */
    private Long memberId;

    /**
     * 购买数量
     *
     * @mbggenerated
     */
    private Integer quantity;

    /**
     * 添加到购物车的价格
     *
     * @mbggenerated
     */
    private BigDecimal price;


    /**
     * 商品主图
     *
     * @mbggenerated
     */
    private String productPic;

    /**
     * 商品名称
     *
     * @mbggenerated
     */
    private String productName;

    /**
     * 商品副标题（卖点）
     *
     * @mbggenerated
     */
    private String productSubTitle;

    /**
     * 会员昵称
     *
     * @mbggenerated
     */
    private String memberNickname;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date modifyDate;

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    private Integer deleteStatus;

    /**
     * 商品品牌
     */
    private String productBrand;


    /**
     * 商品销售属性:{"key":"value"}
     */
    private String productAttributeValue;
}
