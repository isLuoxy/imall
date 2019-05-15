package com.luo.imall.web.dao;

import com.luo.imall.web.entity.OmsOrderItem;
import org.springframework.stereotype.Repository;

/**
 *
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Repository
public interface OmsOrderItemDao {

    /**
     * 新增订单详情类，订单包含的商品
     * @param omsOrderItem
     * @return
     */
    boolean addOmsOrderItem(OmsOrderItem omsOrderItem);
}
