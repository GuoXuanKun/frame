package com.gmgx.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTestAopService {

    TestAopService testAopService  = null;
    @Before
    public void beforeMethod(){

        String path  ="applicationContext.xml";
        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext(path);
        testAopService  =    applicationContext.getBean(TestAopService.class);
    }


    @Test
    public void test1(){
        testAopService.login();

    }


    @Test
    public void test2(){
        System.out.println(testAopService.addMsg("呵sb呵"));

    }

}
