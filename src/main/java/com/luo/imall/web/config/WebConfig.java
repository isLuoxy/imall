package com.luo.imall.web.config;

import com.luo.imall.web.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author L99
 * @createDate 2019/5/12
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("进入拦截器");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/cart/**","/order/**");
    }

}
