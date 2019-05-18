package com.luo.imall.web.dao;

import com.luo.imall.web.entity.BriefOrder;
import com.luo.imall.web.entity.OmsOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * @return 返回插入数据后自增的 id 值
     */
    Long addOrder(OmsOrder omsOrder);

    /**
     * 根据用户名返回用户全部订单
     * @param name
     * @return {@link BriefOrder}
     */
    List<BriefOrder> getAllOrder(String name);

    /**
     * 根据 订单id 返回详情
     * @param id
     * @return {@link OmsOrder}
     */
    List<OmsOrder> getOrderDetailsById(Long id);
}
