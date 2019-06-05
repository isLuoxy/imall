package com.luo.imall.web.vo;

import com.luo.imall.web.annotation.ToReconstruct;
import com.luo.imall.web.dao.PmsProductDao;
import com.luo.imall.web.entity.BriefCartItem;
import com.luo.imall.web.entity.OmsCartItem;
import com.luo.imall.web.entity.PmsProduct;
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

    /** 会员用户名 */
    private String username;

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
     * @param pmsProductDao {@link PmsProductDao}
     * @return {@link OmsCartItem}
     */
    public OmsCartItem toCartItem(PmsProductDao pmsProductDao) {
        // 根据商品id获取商品详情，从中取必要值
        PmsProduct pmsProduct = pmsProductDao.findProductById(productId);

        OmsCartItem omsCartItem = new OmsCartItem();
        // 用户名
        omsCartItem.setUsername(username);
        // 商品id
        omsCartItem.setProductId(productId);
        // 商品编号
        omsCartItem.setProductSn(pmsProduct.getPmsProductAttributeValue().getProductSn());
        // 拼接名称
        omsCartItem.setProductName(pmsProduct.getName() + " " + pmsProduct.getPmsProductAttributeValue().getProductName());
        // 商品品牌
        omsCartItem.setProductBrand(pmsProduct.getBrandName());
        // 商品规格
        omsCartItem.setProductAttributeValue(pmsProduct.getPmsProductAttributeValue().getProductAttributeValue());
        // 创建时间
        omsCartItem.setCreateDate(new Date());
        // 更新时间
        omsCartItem.setModifyDate(new Date());
        // 价格
        omsCartItem.setPrice(price);
        // 数量
        omsCartItem.setQuantity(quantity);

        return omsCartItem;
    }

    /**
     * 转换成 {@link OmsCartItem} 用于更新
     * @return {@link OmsCartItem}
     */
    public OmsCartItem update2CartItem() {
        OmsCartItem omsCartItem = new OmsCartItem();
        omsCartItem.setId(id);
        omsCartItem.setModifyDate(new Date());
        omsCartItem.setQuantity(quantity);
        return omsCartItem;
    }


}
