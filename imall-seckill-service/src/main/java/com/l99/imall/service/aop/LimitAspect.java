package com.l99.imall.service.aop;

import com.google.common.util.concurrent.RateLimiter;
import com.l99.imall.constant.ErrorCode;
import com.l99.imall.pojo.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author L99
 * @createDate 2019/6/28
 *
 */
@Aspect
@Scope
@Component
public class LimitAspect {

    private static RateLimiter rateLimiter = RateLimiter.create(5.0);

    @Pointcut("@annotation(com.l99.imall.service.aop.ServiceLimit)")
    public void ServiceAspect() {
    }

    @Around("ServiceAspect()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Boolean flag = rateLimiter.tryAcquire();
        System.out.println("进入了限流方法");
        Object obj = null;
        try {
            if (flag) {
                obj = joinPoint.proceed();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return (obj == null ? CommonResult.failure(ErrorCode.INVENTORY_NOT_ENOUGH.getCode(), ErrorCode.INVENTORY_NOT_ENOUGH.getDesc()) : obj);
    }
}
