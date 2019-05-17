package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 订单详情基本类
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrderItem {

    private Long id;

    /**
     * 订单id
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
     * 订单编号
     *
     * @mbggenerated
     */
    private String orderSn;

    /**
     * 这里的 商品id 是 具体商品 sku 中的 id，而不是 商品表中的id
     */
    private Long productId;

    private String productPic;

    private String productName;

    private String productBrand;

    private String productSn;

    /**
     * 销售价格
     *
     * @mbggenerated
     */
    private BigDecimal productPrice;

    /**
     * 购买数量
     *
     * @mbggenerated
     */
    private Integer productQuantity;

    /**
     * 商品sku编号
     *
     * @mbggenerated
     */
    private Long productSkuId;

    /**
     * 商品sku条码
     *
     * @mbggenerated
     */
    private String productSkuCode;

    /**
     * 商品分类id
     *
     * @mbggenerated
     */
    private Long productCategoryId;

    /**
     * 商品的销售属性
     *
     * @mbggenerated
     */
    private String sp1;

    private String sp2;

    private String sp3;

    /**
     * 商品促销名称
     *
     * @mbggenerated
     */
    private String promotionName;

    /**
     * 商品促销分解金额
     *
     * @mbggenerated
     */
    private BigDecimal promotionAmount;

    /**
     * 优惠券优惠分解金额
     *
     * @mbggenerated
     */
    private BigDecimal couponAmount;

    /**
     * 积分优惠分解金额
     *
     * @mbggenerated
     */
    private BigDecimal integrationAmount;

    /**
     * 该商品经过优惠后的分解金额
     *
     * @mbggenerated
     */
    private BigDecimal realAmount;

    private Integer giftIntegration;

    /**
     * 成长值
     */
    private Integer giftGrowth;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     *
     * @mbggenerated
     */
    private String productAttr;
}
