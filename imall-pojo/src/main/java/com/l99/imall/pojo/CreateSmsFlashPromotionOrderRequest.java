package com.l99.imall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 秒杀商品请求类
 * @author L99
 * @createDate 2019/5/27
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSmsFlashPromotionOrderRequest implements Serializable {

    /**
     * 秒杀基本信息
     */
    private SmsFlashPromotionOrder flashPromotionOrder;

    /**
     * 秒杀商品详情
     */
    private List<SmsFlashPromotionOrderItem> smsFlashPromotionOrderItemList;
}
