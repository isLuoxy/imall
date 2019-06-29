package com.l99.imall.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.l99.imall.constant.ErrorCode;
import com.l99.imall.dao.SmsFlashPromotionOrderDao;
import com.l99.imall.dao.SmsFlashPromotionOrderItemDao;
import com.l99.imall.dao.SmsFlashPromotionProductDao;
import com.l99.imall.pojo.CommonResult;
import com.l99.imall.pojo.CreateSmsFlashPromotionOrderRequest;
import com.l99.imall.pojo.SmsFlashPromotionOrder;
import com.l99.imall.pojo.SmsFlashPromotionOrderItem;
import com.l99.imall.service.ISmsFlashPromotionOrderService;
import com.l99.imall.service.aop.ServiceLimit;
import com.l99.imall.util.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

/**
 * 秒杀订单 服务层实现接口
 * @author L99
 * @createDate 2019/5/27
 *
 */
@Service(version = "1.0", timeout = 1200000)
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
    @ServiceLimit
    @Transactional(rollbackFor = Exception.class)
    public CommonResult addFlashPromotionOrder(CreateSmsFlashPromotionOrderRequest createSmsFlashPromotionOrderRequest) {
        SmsFlashPromotionOrder order = createSmsFlashPromotionOrderRequest.getFlashPromotionOrder();
        order.setCreateTime(new Date());
        // 设置订单编号
        order.setOrderSn(String.valueOf(IdGenerate.nextId()));
        // 生成订单，减库存
        smsFlashPromotionOrderDao.addFlashPromotionOrder(order);

        List<SmsFlashPromotionOrderItem> orderItemList = createSmsFlashPromotionOrderRequest.getSmsFlashPromotionOrderItemList();

        try {

            orderItemList.stream().forEach(orderItem -> {
                // 由于再生成订单时将自增主键设置为 id 的值，所以直接获取 id 值
                orderItem.setOrderId(order.getId());

                // 新增秒杀商品订单详情
                smsFlashPromotionOrderItemDao.addFlashPromotionOrderItem(orderItem);

                // 对应减库存
                boolean result = smsFlashPromotionProductDao.updateSmsFlashPromotionProductInventory(orderItem.getFlashPromotionProductId(), orderItem.getProductQuantity());

                if (!result) {
                    // 说明库存不足
                    throw new RuntimeException();
                }

            });
        } catch (RuntimeException e) {
            // 这行代码会抛出运行时异常，使事务回滚，并且能够返回值
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return CommonResult.failure(ErrorCode.INVENTORY_NOT_ENOUGH.getCode(), ErrorCode.INVENTORY_NOT_ENOUGH.getDesc());
        }
        return CommonResult.success();
    }
}
