package com.l99.imall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 秒杀商品订单
 * @author L99
 * @createDate 2019/5/27
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsFlashPromotionOrder implements Serializable {

    private Long id;

    /**
     * 秒杀商品订单编号
     */
    private String orderSn;

    /** 支付金额 */
    private BigDecimal money;

    /** 用户id */
    private Long memberId;

    /** 创建时间 */
    private Date createTime;

    /** 支付时间 */
    private Date payTime;

    /** 状态 */
    private Integer status;

    /** 收货人姓名 */
    private String receiverName;

    /** 收货人电话 */
    private String receiverPhone;

    /** 收货人省份 */
    private String receiverProvince;

    /** 城市 */
    private String receiverCity;

    /** 区 */
    private String receiverRegion;

    /** 详细地址 */
    private String receiverDetailAddress;
}
