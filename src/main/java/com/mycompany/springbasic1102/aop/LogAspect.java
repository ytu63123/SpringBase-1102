package com.mycompany.springbasic1102.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)//數字越小越先執行(優先權值)
public class LogAspect {//log的切面

    @Pointcut(value = "execution( * com.mycompany.springbasic1102.aop.*.*(..))")
    public void cut() {

    }

    //前置通知(Advice)
    // @Before(value = "execution( public int com.mycompany.springbasic1102.aop.CalcImpl.add(int, int))")//切入點表達式
    // @Before(value = "execution( public int com.mycompany.springbasic1102.aop.CalcImpl.*(int, int))")//切入點表達式
    // @Before(value = "execution( public int com.mycompany.springbasic1102.aop.*.*(int, int))")//切入點表達式
    // @Before(value = "execution( * *.*(..))")
    @Before(value = "cut()")
    public void before(JoinPoint joinPoint) {
        //獲取方法名稱
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.printf("前置通知->方法名稱: %s ,方法參數 %s \n", methodName, Arrays.toString(args));
    }
    //後置通知(Advice)
    @After(value = "cut()")
    public void after() { //無論是否有例外發生都會被執行，因為作用在finally 中...
        System.out.println("後置通知:");
    }
    // 返回通知(Advice)
    // 獲取返回值
    @AfterReturning(value = "cut()", returning = "result")
    public void afterReturning(Object result) {
        System.out.printf("返回通知:result= %s\n", result);
    }
    //例外通知(Advice)
    @AfterThrowing(value = "cut()",throwing = "ex")
    public void afterThrowing(Exception ex){
    System.out.printf("例外通知(Advice):ex= %s\n", ex);
    }
    
}
