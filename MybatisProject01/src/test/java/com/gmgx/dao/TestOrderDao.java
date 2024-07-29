package com.gmgx.dao;

import com.gmgx.entity.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestOrderDao {

    SqlSession session   =null;

    @Before
    public  void beforeMethod(){
        // 1 找到 sqlmapConfig.xml
        String name  ="SqlMapConfig.xml";
        // 实际上 要从工程角度出发，当前这个文件是在工程的相对位置 得到它的io流
        InputStream is  = TestOrderDao.class.getClassLoader().getResourceAsStream(name);

        // 2 把它加载到 sql会话工厂中 帮你解析(给工厂 加载 了 装备（指导书）)
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3 通过会话工程 ，获得一个 sql会话
         session   =  sessionFactory.openSession();


    }
    @After
    public void afterMethod(){

        // 6 关闭资源
        session.close();

    }



    @Test
    public void testQueryAllOrderAndUser(){

        IOrderDao orderDao  =   session.getMapper(IOrderDao.class);
        List<Order>  list  =  orderDao.queryAllOrderAndUser();
        for (Order o : list){
            System.out.println(o);
        }


    }


    @Test
    public void testQueryAllOrderAndUser2(){

        IOrderDao orderDao  =   session.getMapper(IOrderDao.class);
        List<Order>  list  =  orderDao.queryAllOrderAndUser2();
        for (Order o : list){
            System.out.println(o);
        }


    }

}