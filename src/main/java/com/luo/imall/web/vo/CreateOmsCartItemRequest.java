package com.luo.imall.web.vo;

import com.luo.imall.web.annotation.ToReconstruct;
import com.luo.imall.web.entity.BriefCartItem;
import com.luo.imall.web.entity.OmsCartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * 创建会员购物车请求对象 用于封装用户对象
 * @author L99
 * @createDate 2019/5/14
 *
 * 这个类和 {@link OmsCartItem} 基本属性相同，所以可以直接使用 {@link OmsCartItem}
 *
 */
@ToReconstruct
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOmsCartItemRequest {

    /** id */
    private Long id;

    /** 商品具体 sku id */
    private Long productId;

    /** 会员id */
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
     * 商品名称
     *
     * @mbggenerated
     */
    private String productName;

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
     */
    private Date modifyDate;

    /**
     *  商品编号
     */
    private Long productSn;

    /**
     *  商品品牌
     */
    private String productBrand;

    /**
     * 商品属性
     */
    private String productAttributeValue;

    /**
     * 用于转换成 {@link OmsCartItem}
     * @return {@link OmsCartItem}
     */
    public OmsCartItem toCartItem() {
        OmsCartItem omsCartItem = new OmsCartItem();
        omsCartItem.setMemberId(memberId);
        omsCartItem.setProductId(productId);
        omsCartItem.setCreateDate(new Date());
        omsCartItem.setModifyDate(new Date());
        omsCartItem.setProductName(productName);
        omsCartItem.setMemberNickname(memberNickname);
        omsCartItem.setProductAttributeValue(productAttributeValue);
        omsCartItem.setPrice(price);
        omsCartItem.setProductSn(productSn);
        omsCartItem.setQuantity(quantity);
        omsCartItem.setProductBrand(productBrand);
        return omsCartItem;
    }

    /**
     * 转换成 {@link OmsCartItem} 用于更新
     * @return {@link OmsCartItem}
     */
    public OmsCartItem update2CartItem(){
        OmsCartItem omsCartItem = new OmsCartItem();
        omsCartItem.setId(id);
        omsCartItem.setModifyDate(new Date());
        omsCartItem.setQuantity(quantity);
        return omsCartItem;
    }


}
