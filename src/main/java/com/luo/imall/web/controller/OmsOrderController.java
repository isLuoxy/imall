package com.luo.imall.web.controller;

import com.luo.imall.web.service.IOmsOrderService;
import com.luo.imall.web.vo.CreateOmsOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制器类
 * @author L99
 * @createDate 2019/5/15
 *
 */
@RestController
@Slf4j
public class OmsOrderController {


    @Autowired
    IOmsOrderService omsOrderService;

    @PostMapping("/order")
    public Object addOrder(@RequestBody CreateOmsOrderRequest omsOrderRequest) throws Exception {
        return omsOrderService.addOmsOrder(omsOrderRequest);
    }


}
