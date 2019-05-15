package com.luo.imall.web.dao;

import com.luo.imall.web.entity.OmsOrder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Repository
public interface OmsOrderDao {

    /**
     * 新增订单基本信息
     * @param omsOrder
     * @return
     */
    boolean addOrder(OmsOrder omsOrder);
}
