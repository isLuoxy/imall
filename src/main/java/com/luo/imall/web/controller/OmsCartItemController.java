package com.luo.imall.web.controller;

import com.luo.imall.web.constant.ErrorCode;
import com.luo.imall.web.service.IOmsCartItemService;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateOmsCartItemRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 购物车控制类
 * @author L99
 * @createDate 2019/5/14
 *
 */
@RestController
@Slf4j
public class OmsCartItemController {


    @Autowired
    IOmsCartItemService cartItemService;

    /**
     * 通过用户名查看购物车
     * @param request
     * @return
     */
    @GetMapping("/cart")
    public Object getCart(HttpServletRequest request) {
        // 查看当前 鉴权情况

        Object authentication = request.getAttribute("authentication");

        log.info("getCart: {}", authentication);

        if (authentication == null) {
            return CommonResult.failure(ErrorCode.ABNORMAL_STATUE.getCode(), ErrorCode.ABNORMAL_STATUE.getDesc());
        }

        String name = (String) request.getAttribute("name");
        CommonResult result = cartItemService.getCartByName(name);

        request.removeAttribute("authentication");
        request.removeAttribute("name");

        return result;
    }

    @PostMapping("/cart")
    public Object addCart(@RequestBody CreateOmsCartItemRequest omsCartItemRequest) {
        log.info("addCart: {}", omsCartItemRequest);
        omsCartItemRequest.setCreateDate(new Date());
        CommonResult result = cartItemService.addCart(omsCartItemRequest);
        return result;
    }

    @PutMapping("/cart")
    public Object updateCart(@RequestBody CreateOmsCartItemRequest omsCartItemRequest) {
        log.info("updateCart: {}", omsCartItemRequest);
        CommonResult result = cartItemService.updateCart(omsCartItemRequest);

        return result;
    }
}
