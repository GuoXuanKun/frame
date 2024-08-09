package com.gmgx.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop07_注解版2 {


    // 这种写法 可以更灵活的定义不同 切点下的通知
    // 缺点是 每次都要写很长的表达式

    @Before("execution(* com.gmgx.service.IStudentService.*(..))")
    public void beforeMethod(){
        System.out.println("IStudentService  beforeMethod");

    }


    @Before("execution(* com.gmgx.service.ITeacherService.*(..))")
    public void beforeMethod2(){
        System.out.println("ITeacherService beforeMethod");

    }




}
