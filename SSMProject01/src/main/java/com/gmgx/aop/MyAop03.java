package com.gmgx.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MyAop03 {



    // 环绕通知 （  四合一 ）
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(pjp.getTarget().getClass());
        System.out.println(pjp.getSignature().getName());
        System.out.println("什么情况下会进来");
        return  pjp.proceed();

    }


}
