package com.gmgx.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

    @Test
    public void testTransferAccounts(){
        ClassPathXmlApplicationContext applicationContext   = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService   =   applicationContext.getBean(IUserService.class);
        userService.transferAccounts(1,5,100);

    }
}
