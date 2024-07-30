package com.gmgx.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class TestBlogDao {

    SqlSession session1   =null;
    SqlSession session2   =null;
    @Before
    public  void beforeMethod(){
        // 1 找到 sqlmapConfig.xml
        String name  ="SqlMapConfig.xml";
        // 实际上 要从工程角度出发，当前这个文件是在工程的相对位置 得到它的io流
        InputStream is  = TestBlogDao.class.getClassLoader().getResourceAsStream(name);

        // 2 把它加载到 sql会话工厂中 帮你解析(给工厂 加载 了 装备（指导书）)
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3 通过会话工程 ，获得一个 sql会话
         session1   =  sessionFactory.openSession();

        session2   =  sessionFactory.openSession();
    }
    @After
    public void afterMethod(){

        // 6 关闭资源
        session1.close();
        session2.close();
    }



   @Test
    public void testQueryAllBlog(){

      IBlogDao blogDao1  =  session1.getMapper(IBlogDao.class);
       System.out.println(blogDao1.queryAllBlog());
       System.out.println("-------------");
       System.out.println(blogDao1.queryAllBlog());
       System.out.println("=======================");


       IBlogDao blogDao2  =  session2.getMapper(IBlogDao.class);
       System.out.println(blogDao2.queryAllBlog());
       System.out.println("-------------");
       System.out.println(blogDao2.queryAllBlog());
   }



}