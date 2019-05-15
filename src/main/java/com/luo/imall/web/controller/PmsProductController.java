package com.luo.imall.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品控制器
 * @author L99
 * @createDate 2019/5/14
 *
 */
@RestController
public class PmsProductController {

    /**
     * 获取商品详情
     * @return
     */
    @GetMapping("/product/{id}")
    public Object productDetail(@PathVariable Long id){
        return null;
    }
}
