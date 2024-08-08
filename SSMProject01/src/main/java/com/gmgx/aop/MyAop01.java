package com.gmgx.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


@Component
public class MyAop01 {

    //写方法（目标代码 执行前 调用我 的方法）
    public void beforeMethod(){
        System.out.println("我是 before 方法，我被人通知要执行了");
    }


    //写方法（目标代码 执行后 调用我 的方法）
    public void afterMethod(){
        System.out.println("我是 after 方法，我被人通知要执行了");
    }

    //写方法（目标代码 执行后并返回数据（return后） 调用我 的方法）


    //写方法（目标代码 报错了 调用我 的方法）

}