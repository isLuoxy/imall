package com.luo.imall.web.entity;

import com.luo.imall.web.util.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单内容返回信息封装
 * @author L99
 * @createDate 2019/5/17
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefOrder {
    private Long id;

    /**
     * 会员id
     *
     * @mbggenerated
     */
    private Long memberId;

    /**
     * 简略订单包含商品信息封装
     * {@link BriefOrderItem}
     */
    private List<BriefOrderItem> product;

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
     * 用户账号
     *
     * @mbggenerated
     */
    private String memberUsername;

    /**
     * 订单总金额
     *
     * @mbggenerated
     */
    private BigDecimal totalAmount;


    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     *
     * @mbggenerated
     */
    private Integer status;


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
     * 将时间格式转换成字符串
     */
    public final void convertsTime2String(){
        this.setCreateTime(TimeUtil.FORMATTime2String(TimeUtil.YYYY_MM_DD_HH_MM_SS,(Date) createTime));
    }
}
