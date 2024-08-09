package com.gmgx.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Component
public class MyAop02 {

    @Autowired
    private HttpServletRequest request;
    /**
     * 日志记录 记录 目标方法（切点）的所有信息（1 操作人 2 类名 3 方法名 4 参数 5 返回值 6 执行时间（开始时间 结束时间）7 执行时间（是否超时）  ）
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object logRecording(ProceedingJoinPoint joinPoint)  {


        // 设计一个表：存的是这些内容 （1 操作人 2 类名 3 方法名 4 参数 5 返回值 6 执行时间（开始时间 结束时间）7 执行时间（是否超时）


        System.out.println("开始日志记录");
        if(request!=null){
            System.out.println("操作人："+request.getSession().getAttribute("my"));
        }else{
            System.out.println("操作人：单元测试");
        }


        // 获得类名
        System.out.println("获得类名："+joinPoint.getTarget().getClass());
        System.out.println("获得方法名："+joinPoint.getSignature().getName());
        System.out.println("获得参数："+Arrays.toString(joinPoint.getArgs()));

        Long start =System.currentTimeMillis();
        System.out.println("开始时间:"+start);
        Object data  = null;
        try {
            data = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("记录异常信息:"+new Date().toLocaleString() +":"+e.getMessage());
            throw new RuntimeException(e);
        }
        Long end =System.currentTimeMillis();
        System.out.println("结束时间:"+end);
        System.out.println("共使用时间："+(end-start));

        // System.out.println("返回值："+data);
        // 将对象 转换成 json格式  （jackson包中的对象 ）
        ObjectMapper mapper  = new ObjectMapper();
        try {

            System.out.println("返回值："+mapper.writeValueAsString(data));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        return  data;
    }


}
