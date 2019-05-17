package com.luo.imall.web.controller;

import com.luo.imall.web.constant.ErrorCode;
import com.luo.imall.web.service.IOmsCartItemService;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateOmsCartItemRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/cart")
    public Object getCart(HttpServletRequest request) {
        // 查看当前 鉴权情况

        Object authentication = request.getAttribute("authentication");

        log.info("getCart: {}", authentication);

        if(authentication == null){
            return CommonResult.failure(ErrorCode.ABNORMAL_STATUE.getCode(),ErrorCode.ABNORMAL_STATUE.getDesc());
        }

        String name = (String)request.getAttribute("name");
        CommonResult result = cartItemService.getCartByName(name);

        request.removeAttribute("authentication");
        request.removeAttribute("name");

        return result;
    }

    @PostMapping("/cart")
    public Object addCart(@RequestBody CreateOmsCartItemRequest omsCartItemRequest) {
        log.info("addCart: {}", omsCartItemRequest);
        CommonResult result = cartItemService.addCart(omsCartItemRequest);
        return result;
    }
}