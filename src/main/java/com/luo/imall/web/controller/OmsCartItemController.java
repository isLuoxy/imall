package com.luo.imall.web.controller;

import com.luo.imall.web.service.IOmsCartItemService;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateOmsCartItemRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cart/{id}")
    public Object getCart(@PathVariable Long id) {
        log.info("getCart: {}", id);
        CreateOmsCartItemRequest omsCartItemRequest = new CreateOmsCartItemRequest();
        omsCartItemRequest.setMemberId(id);

        CommonResult result = cartItemService.getCart(omsCartItemRequest);
        return result;
    }

    @PostMapping("/cart")
    public Object addCart(@RequestBody CreateOmsCartItemRequest omsCartItemRequest) {
        log.info("addCart: {}", omsCartItemRequest);
        CommonResult result = cartItemService.addCart(omsCartItemRequest);
        return result;
    }
}
