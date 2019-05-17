package com.luo.imall.web.vo;

import com.google.common.annotations.VisibleForTesting;
import com.luo.imall.web.dao.OmsOrderItemDao;
import com.luo.imall.web.entity.OmsOrder;
import com.luo.imall.web.entity.OmsOrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.*;

/**
 * 创建订单请求对象 用于封装订单对象
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOmsOrderRequest {

    /** 订单 id */
    private Long id;

    /** 会员 id */
    private Long memberId;

    /** 会员账号 */
    private String memberUsername;

    /** 订单总金额 */
    private BigDecimal totalAmount;

    /** 实际支付金额 */
    private BigDecimal payAmount;

    /** 促销优化金额 */
    private BigDecimal promotionAmount;

    /**
     * 0 -> 未支付； 1 -> 支付宝 ；  2-> 微信
     *
     */
    private Integer payType;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     *
     */
    private Integer status;

    /**
     * 订单类型： 0 -> 正常订单 1 -> 秒杀订单
     *
     */
    private Integer orderType;

    /**
     * 运费金额
     *
     */
    private BigDecimal freightAmount;


    /**
     * 收货人姓名
     *
     */
    private String receiverName;

    /**
     * 收货人电话
     *
     */
    private String receiverPhone;

    /**
     * 省份/直辖市
     *
     */
    private String receiverProvince;

    /**
     * 城市
     *
     * @mbggenerated
     */
    private String receiverCity;

    /**
     * 区
     *
     * @mbggenerated
     */
    private String receiverRegion;

    /**
     * 详细地址
     *
     * @mbggenerated
     */
    private String receiverDetailAddress;

    /**
     * 订单备注
     *
     * @mbggenerated
     */
    private String note;

    private List<CreateOmsOrderItemRequest> createOmsOrderItemRequests;

    public OmsOrder toOmsOrder() {
        OmsOrder omsOrder = new OmsOrder();

        omsOrder.setMemberId(memberId);
        omsOrder.setMemberUsername(memberUsername);
        omsOrder.setOrderSn(UUID.randomUUID().toString());
        omsOrder.setCreateTime(new Date());
        omsOrder.setTotalAmount(totalAmount);
        omsOrder.setPayAmount(payAmount);
        omsOrder.setPayType(payType);
        omsOrder.setStatus(status);
        omsOrder.setPromotionAmount(promotionAmount);
        omsOrder.setOrderType(orderType);
        omsOrder.setFreightAmount(freightAmount);
        omsOrder.setReceiverName(receiverName);
        omsOrder.setReceiverPhone(receiverPhone);
        omsOrder.setReceiverCity(receiverCity);
        omsOrder.setReceiverRegion(receiverRegion);
        omsOrder.setReceiverDetailAddress(receiverDetailAddress);
        omsOrder.setNote(note);

        return omsOrder;
    }

    /**
     * 将 CreateOmsOrderItemRequest 变为 OmsOrderItem 的集合
     * @param omsOrder {@link OmsOrder}
     * @return 返回 OmsOrderItem 集合
     */
    public List<OmsOrderItem> toOmsOrderItemList(OmsOrder omsOrder) {

        List<OmsOrderItem> omsOrderItemList = new LinkedList<>();

        createOmsOrderItemRequests.stream().forEach((order) -> {
            OmsOrderItem omsOrderItem = new OmsOrderItem();
            omsOrderItem.setOrderId(omsOrder.getId());
            omsOrderItem.setOrderSn(omsOrder.getOrderSn());
            omsOrderItem.setProductId(order.getProductId());
            omsOrderItem.setProductName(order.getProductName());
            omsOrderItem.setProductPrice(order.getProductPrice());
            omsOrderItem.setProductQuantity(order.getProductQuantity());
            omsOrderItem.setPromotionName(order.getPromotionName());
            omsOrderItem.setPromotionAmount(order.getPromotionAmount());
            omsOrderItem.setRealAmount(order.getRealAmount());
            omsOrderItemList.add(omsOrderItem);
        });

        return omsOrderItemList;
    }

}
