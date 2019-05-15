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

    private Long productId;

    private Long productSkuId;

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
     * 商品sku条码
     *
     * @mbggenerated
     */
    private String productSkuCode;

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
     * 商品分类
     *
     * @mbggenerated
     */
    private Long productCategoryId;

    private String productBrand;

    private String productSn;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     *
     */
    private String productAttr;
}
