package com.l99.imall.service.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 自定义注解 限流
 * @author L99
 * @createDate 2019/6/28
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface ServiceLimit {
    String description() default "";
}
