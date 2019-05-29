package com.l99.imall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.l99.imall.dao.SmsFlashPromotionOrderDao;
import com.l99.imall.dao.SmsFlashPromotionOrderItemDao;
import com.l99.imall.dao.SmsFlashPromotionProductDao;
import com.l99.imall.pojo.CommonResult;
import com.l99.imall.pojo.CreateSmsFlashPromotionOrderRequest;
import com.l99.imall.pojo.SmsFlashPromotionOrder;
import com.l99.imall.pojo.SmsFlashPromotionOrderItem;
import com.l99.imall.service.ISmsFlashPromotionOrderService;
import com.l99.imall.util.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 秒杀订单 服务层实现接口
 * @author L99
 * @createDate 2019/5/27
 *
 */
@Service(version = "1.0")
public class SmsFlashPromotionOrderServiceImpl implements ISmsFlashPromotionOrderService {

    /** 秒杀商品用户基本信息 dao */
    @Autowired
    SmsFlashPromotionOrderDao smsFlashPromotionOrderDao;

    /** 秒杀商品的基本信息 dao  */
    @Autowired
    SmsFlashPromotionProductDao smsFlashPromotionProductDao;

    /** 秒杀商品的详情信息 dao */
    @Autowired
    SmsFlashPromotionOrderItemDao smsFlashPromotionOrderItemDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult addFlashPromotionOrder(CreateSmsFlashPromotionOrderRequest createSmsFlashPromotionOrderRequest) {
        SmsFlashPromotionOrder order = createSmsFlashPromotionOrderRequest.getFlashPromotionOrder();
        order.setCreateTime(new Date());
        // 设置订单编号
        order.setOrderSn(String.valueOf(IdGenerate.nextId()));
        // 生成订单，减库存
        Long id = smsFlashPromotionOrderDao.addFlashPromotionOrder(order);

        List<SmsFlashPromotionOrderItem> orderItemList = createSmsFlashPromotionOrderRequest.getSmsFlashPromotionOrderItemList();

        orderItemList.stream().forEach(orderItem -> {
            orderItem.setOrderId(order.getId());
            // 对应减库存
            boolean result = smsFlashPromotionProductDao.updateSmsFlashPromotionProductInventory(orderItem.getFlashPromotionProductId(), orderItem.getProductQuantity());

            if (result) {
                // 新增秒杀商品订单详情
                smsFlashPromotionOrderItemDao.addFlashPromotionOrderItem(orderItem);
            }
        });
        return CommonResult.success();
    }
}
