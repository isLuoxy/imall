package com.luo.imall.web;

import com.luo.imall.web.dao.OmsOrderDao;
import com.luo.imall.web.entity.BriefOrder;
import com.luo.imall.web.entity.OmsOrder;
import net.sf.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *
 * @author L99
 * @createDate 2019/5/18
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class orderTest {

    @Autowired
    OmsOrderDao omsOrderDao;

    /**
     * {@link OmsOrderDao}
     * @see OmsOrderDao#getAllOrder(String)
     */
    @Test
    public void getAllOrder() {
        List<BriefOrder> test = omsOrderDao.getAllOrder("test");
        System.out.println(JSONArray.fromObject(test).toString());
    }

    /**
     * {@link OmsOrderDao}
     *  @see OmsOrderDao#getOrderDetailsById(Long)
     */
    @Test
    public void getOrderDetailsById() {
        List<OmsOrder> orderDetailsById = omsOrderDao.getOrderDetailsById(7l);
        orderDetailsById.stream().forEach(omsOrder -> {
            omsOrder.convertsTime2String();
        });
        System.out.println(JSONArray.fromObject(orderDetailsById).toString());
    }
}
