package com.mycompany.springbasic1102.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class CheckAspect {

    //公用表達式
    @Pointcut(value = "execution(* com.mycompany.springbasic1102.aop.BMIImpl.*(..))")
    public void cut() {
    }
    //環繞通知

    @Around(value = "cut()")
    public Object arround(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            //前置通知
            System.out.println("環繞通知-前置通知");
            result = joinPoint.proceed();//執行方法
            //返回通知
            System.out.println("環繞通知-返回通知 result = "+result);
        } catch (Throwable e) {
            //異常通知
            e.printStackTrace();           
            System.out.println("環繞通知-異常通知");
        } finally {
            //後置通知
            System.out.println("環繞通知-後置通知");
        }

        return result;
    }

}
