package com.luo.imall.web.entity;

import com.luo.imall.web.util.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * 订单基本类
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrder {

    private Long id;

    /**
     * 会员id
     *
     * @mbggenerated
     */
    private Long memberId;

    /**
     * 获取订单中商品的信息
     * {@link OmsOrderItem}
     */
    List<OmsOrderItem> product;

    String memberUsername;

    /**
     * 优惠券 id
     *
     * @mbggenerated
     */
    private Long couponsId;

    /**
     * 订单编号
     *
     * @mbggenerated
     */
    private String orderSn;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Object createTime;


    /**
     * 订单总金额
     *
     * @mbggenerated
     */
    private BigDecimal totalAmount;

    /**
     * 应付金额（实际支付金额）
     *
     * @mbggenerated
     */
    private BigDecimal payAmount;

    /**
     * 0 -> 未支付； 1 -> 支付宝 ；  2-> 微信
     *
     * @mbggenerated
     */
    private Integer payType;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 订单类型： 0 -> 正常订单 1 -> 秒杀订单
     *
     * @mbggenerated
     */
    private Integer orderType;

    /**
     * 获得的成长值
     *
     * @mbggenerated
     */
    private Integer growth;

    /**
     * 发货时间
     *
     * @mbggenerated
     */
    private Date deliveryTime;

    /**
     * 支付时间
     *
     * @mbggenerated
     */
    private Date payTime;

    /**
     * 收货时间
     *
     * @mbggenerated
     */
    private Date receiverTime;

    /**
     * 运费金额
     *
     * @mbggenerated
     */
    private BigDecimal freightAmount;

    /**
     * 促销优化金额（促销价、满减、阶梯价）
     *
     * @mbggenerated
     */
    private BigDecimal promotionAmount;

    /**
     * 积分抵扣金额
     *
     * @mbggenerated
     */
    private BigDecimal integrationAmount;

    /**
     * 优惠券抵扣金额
     *
     * @mbggenerated
     */
    private BigDecimal couponAmount;

    /**
     * 管理员后台调整订单使用的折扣金额
     *
     * @mbggenerated
     */
    private BigDecimal discountAmount;

    /**
     * 物流公司
     *
     * @mbggenerated
     */
    private String deliveryCompany;

    /**
     * 物流单号
     *
     * @mbggenerated
     */
    private String deliverySn;

    /**
     * 自动确认时间
     *
     * @mbggenerated
     */
    private Integer autoConfirmDay;

    /**
     * 可以获得的积分
     *
     * @mbggenerated
     */
    private Integer integration;

    /**
     * 收货人姓名
     *
     * @mbggenerated
     */
    private String receiverName;

    /**
     * 收货人电话
     *
     * @mbggenerated
     */
    private String receiverPhone;

    /**
     * 省份/直辖市
     *
     * @mbggenerated
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


    /**
     * 将时间格式转换成字符串
     */
    public final void convertsTime2String(){
        this.setCreateTime(TimeUtil.FORMATTime2String(TimeUtil.YYYY_MM_DD_HH_MM_SS,(Date) createTime));
    }
}
