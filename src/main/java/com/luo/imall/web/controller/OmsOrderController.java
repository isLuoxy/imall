package com.luo.imall.web.controller;

import com.luo.imall.web.constant.ErrorCode;
import com.luo.imall.web.service.IOmsOrderService;
import com.luo.imall.web.util.UserStatusUtil;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateOmsOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 加入商品到订单中,结算功能
     * @param omsOrderRequest
     * @return
     * @throws Exception
     */
    @PostMapping("/order")
    public Object addOrder(@RequestBody CreateOmsOrderRequest omsOrderRequest) throws Exception {
        return omsOrderService.addOmsOrder(omsOrderRequest);
    }

    /**
     * 显示所有订单
     * @return
     */
    @GetMapping("/order")
    public Object getAllOrder(HttpServletRequest request) {


        boolean isLogin = UserStatusUtil.isLogin(request);
        log.info("getAllOrder: {}", isLogin);
        if (!isLogin) {
            return CommonResult.failure(ErrorCode.ABNORMAL_STATUE.getCode(), ErrorCode.ABNORMAL_STATUE.getDesc());
        }

        String name = (String)request.getAttribute("name");

        CreateOmsOrderRequest omsOrderRequest = new CreateOmsOrderRequest();
        omsOrderRequest.setMemberUsername(name);

        request.removeAttribute("authentication");
        request.removeAttribute("name");

        return omsOrderService.getAllOrder(omsOrderRequest);
    }

    /**
     * 根据订单号显示订单详情
     */
    @GetMapping("/order/{id}")
    public Object getOrderDetailsById(@PathVariable Long id, HttpServletRequest request) {

        boolean isLogin = UserStatusUtil.isLogin(request);
        log.info("getOrderDetailsById: {}", isLogin);
        if (!isLogin) {
            return CommonResult.failure(ErrorCode.ABNORMAL_STATUE.getCode(), ErrorCode.ABNORMAL_STATUE.getDesc());
        }

        return omsOrderService.getOrderDetailsById(id);
    }
}
