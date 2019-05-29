package com.l99.imall;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.l99.imall.pojo.CreateSmsFlashPromotionOrderRequest;
import com.l99.imall.pojo.SmsFlashPromotionOrder;
import com.l99.imall.pojo.SmsFlashPromotionOrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author L99
 * @createDate 2019/5/27
 *
 */
public class test {
    public static void main(String[] args) {
        CreateOrder createOrder = new CreateOrder();
        SmsFlashPromotionOrder smsFlashPromotionOrder = new SmsFlashPromotionOrder();
        smsFlashPromotionOrder.setMoney(new BigDecimal(200));
        smsFlashPromotionOrder.setReceiverName("L99");
        smsFlashPromotionOrder.setReceiverPhone("13104884646");
        SmsFlashPromotionOrderItem smsFlashPromotionOrderItem = new SmsFlashPromotionOrderItem();
        smsFlashPromotionOrderItem.setProductQuantity(10);
        smsFlashPromotionOrderItem.setFlashPromotionProductId(1L);
        SmsFlashPromotionOrderItem smsFlashPromotionOrderItem2 = new SmsFlashPromotionOrderItem();
        smsFlashPromotionOrderItem2.setProductQuantity(20);
        smsFlashPromotionOrderItem2.setFlashPromotionProductId(2L);
        List<SmsFlashPromotionOrderItem> list = new ArrayList<>();
        list.add(smsFlashPromotionOrderItem);
        list.add(smsFlashPromotionOrderItem2);

        createOrder.setFlashPromotionOrder(smsFlashPromotionOrder);
        createOrder.setSmsFlashPromotionOrderItemList(list);

        System.out.println(JSON.toJSONString(createOrder));

//        CreateSmsFlashPromotionOrderRequest request = JSON.parseObject("{\"flashPromotionOrder\":{\"money\":200},\"smsFlashPromotionOrderItemList\":[{\"orderId\":201313}]}", CreateSmsFlashPromotionOrderRequest.class);
//        System.out.println(request);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class CreateOrder{
    private SmsFlashPromotionOrder flashPromotionOrder;

    private List<SmsFlashPromotionOrderItem> smsFlashPromotionOrderItemList;
}
