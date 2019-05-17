package com.luo.imall.web.service.impl;

import com.luo.imall.web.dao.OmsOrderDao;
import com.luo.imall.web.dao.OmsOrderItemDao;
import com.luo.imall.web.dao.PmsProductAttibuteValueDao;
import com.luo.imall.web.entity.OmsOrder;
import com.luo.imall.web.entity.OmsOrderItem;
import com.luo.imall.web.entity.PmsProductAttibuteValue;
import com.luo.imall.web.service.IOmsOrderService;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateOmsOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Service
public class OmsOrderServiceImpl implements IOmsOrderService {

    @Autowired
    OmsOrderDao omsOrderDao;

    @Autowired
    OmsOrderItemDao omsOrderItemDao;

    @Autowired
    PmsProductAttibuteValueDao pmsProductAttibuteValueDao;

    /**
     * 这里未考虑到下订单 还未付款的情况
     * @param createOmsOrderRequest
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResult addOmsOrder(CreateOmsOrderRequest createOmsOrderRequest) throws Exception {

        OmsOrder omsOrder = createOmsOrderRequest.toOmsOrder();

        Long id = omsOrderDao.addOrder(omsOrder);

        // 把存放订单的后的自增id 存储
        omsOrder.setId(id);

        List<OmsOrderItem> omsOrderItemList = createOmsOrderRequest.toOmsOrderItemList(omsOrder);

        omsOrderItemList.stream().forEach((orderItem) -> {

            // 添加 订单详情
            omsOrderItemDao.addOmsOrderItem(orderItem);

            PmsProductAttibuteValue pmsProductAttibuteValue = new PmsProductAttibuteValue();
            // 获取订单中购买的商品对应的 sku id
            pmsProductAttibuteValue.setId(orderItem.getProductId());
            // 获取订单中商品数量，对应库存减少多少数量
           // pmsProductAttibuteValue.setDifference(orderItem.getProductQuantity());
            pmsProductAttibuteValueDao.inventoryReduction(pmsProductAttibuteValue);
        });
        // 下订单减库存，对应商品的库存量减少

        return CommonResult.success();
    }
}
