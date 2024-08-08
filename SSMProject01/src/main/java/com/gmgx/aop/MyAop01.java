package com.gmgx.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MyAop01 {

    // 代码实现 日志打印
    //private static Logger logger  = Logger.getLogger(MyAop01.class);
    //写方法（目标代码 执行前 调用我 的方法）
    public void beforeMethod(){
        //log.info("1111");
        //logger.debug("111");

        // System.out.println("我是 before 方法，我被人通知要执行了");
        // 将要显示的内容 放在 日志中（如果有配置 本文文件  保留本地文件中 .log4j）
        log.debug("我是 before 方法，我被人通知要执行了");
    }


    //写方法（目标代码 执行后 调用我 的方法）
    public void afterMethod(){
//        System.out.println("我是 after 方法，我被人通知要执行了");
        log.debug("我是 after 方法，我被人通知要执行了");
    }

    //写方法（目标代码 执行后并返回数据（return后） 调用我 的方法）

    public void afterReturningMethod(){
//        System.out.println("我是 afterReturning 方法，我被人通知要执行了");
        log.debug("我是 afterReturning 方法，我被人通知要执行了");
    }

}
