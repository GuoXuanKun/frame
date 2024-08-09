package com.gmgx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop07_注解版 {


    // 配一个切点 所有的通知注解 引用这个切点方法（注意括号）
    @Pointcut("execution(* com.gmgx.service.IStudentService.*(..))")
    public void method1(){
        // 这是一个普普通通没有任何代码的空方法，目的为了表示 切点
    }

    @Pointcut("execution(* com.gmgx.service.IStudentService.*(..))")
    public void method2(){
        // 这是一个普普通通没有任何代码的空方法，目的为了表示 切点
    }


    @Before("method1()") // 切点方法（注意 有 括号）
    public void beforeMethod(){
        System.out.println("beforeMethod");

    }

    @After("method1()") // 切点方法
    public void afterMethod(){
        System.out.println("afterMethod");

    }

    @AfterReturning("method1()") // 切点方法
    public void afterReturningMethod(){
        System.out.println("afterReturningMethod");

    }

    @AfterThrowing("method1()") // 切点方法
    public void afterThrowingMethod(){
        System.out.println("afterThrowingMethod");

    }
    @Around("method1()") // 切点方法
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aroundMethod");
         return joinPoint.proceed();

    }






}
