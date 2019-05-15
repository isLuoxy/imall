package com.luo.imall.web.vo;

import com.luo.imall.web.entity.OmsCartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 创建会员请求对象 用于封装用户对象
 * @author L99
 * @createDate 2019/5/14
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOmsCartItemRequest {

    private Long productId;

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


    public OmsCartItem toCartItem() {
        OmsCartItem omsCartItem = new OmsCartItem();
        omsCartItem.setMemberId(memberId);
        omsCartItem.setProductId(productId);
        omsCartItem.setCreateDate(new Date());
        omsCartItem.setProductName(productName);
        omsCartItem.setMemberNickname(memberNickname);
        return omsCartItem;
    }
}
