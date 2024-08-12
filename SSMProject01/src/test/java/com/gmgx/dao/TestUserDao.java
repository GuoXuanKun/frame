package com.gmgx.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {

    IUserDao  userDao  = null;
    @Before
    public void beforeMethod(){

        String path  ="applicationContext.xml";
        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext(path);
        userDao  =    applicationContext.getBean(IUserDao.class);
    }



    @Test
    public void testQueryAllStudent(){


        userDao.modifyMoney(1,-100.0);


    }




}
