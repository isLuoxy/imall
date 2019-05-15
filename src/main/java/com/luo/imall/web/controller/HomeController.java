package com.luo.imall.web.controller;

import com.luo.imall.web.service.IHomeService;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.HomeContentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页控制器类
 * @author L99
 * @createDate 2019/5/11
 *
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    IHomeService homeService;



    /**
     * 获取首页内容
     * @return
     */
    @GetMapping("/content")
    @ResponseBody
    public Object content(){
        HomeContentResult contentResult = homeService.getContent();
        // 通过通用返回对象组装结果
        CommonResult result = new CommonResult(contentResult);
        return result;
    }


}
