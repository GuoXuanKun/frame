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
    //写方法（目标代码 报错了 调用我 的方法）
    public void afterThrowingMethod(){
//        System.out.println("我是 afterThrowing 方法，我被人通知要执行了");
        log.debug("我是 afterThrowing 方法，我被人通知要执行了");
    }


    // 环绕通知 （  四合一 ）
    public Object aroundMethod(ProceedingJoinPoint pjp){

        // 记录 日志信息（什么时候执行什么动作）
        // 记录  执行时间（开始时间 到 结束时间） +判断 是否超时 （规定每个方法的执行时间不能超过5s）
        // 记录 异常信息（也可以实现异常处理）
        // 做一些 参数 或者 返回值  校验（是否有敏感字 关键字 进行替换 红色魔杖 红**杖 ）查资料
        // 记录 某个类 或 某个方法 被执行的次数
        // 百度一下（尝试完成几个）

        Object[] args  =  pjp.getArgs();
        for (Object arg: args){

            System.out.println(arg);
            if(arg.toString().contains("sb")){

                log.warn("参数有敏感字"+arg.toString()+",不让他提交");

                return false;
            }

        }

        Object obj = null;
        log.debug("这个位置 ，相当于  前置通知  ");
        try {
            // 让 连接点   继续执行  动作？？？
            // 代理人 调用 目标方法 （如果没有调用，就没有执行目标方法  ）
            obj  =  pjp.proceed();// 目标方法 被执行
            log.debug("这个位置，相当于返回通知");
        } catch (Throwable e) {
            log.debug("这个位置，相当于异常通知");
            e.printStackTrace();

        }
        log.debug("这个位置，相当于后置通知");
//        System.out.println("");
        return  obj;
    }


}
