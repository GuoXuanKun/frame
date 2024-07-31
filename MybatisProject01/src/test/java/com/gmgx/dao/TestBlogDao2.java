package com.gmgx.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class TestBlogDao2 {

    SqlSession session1   =null;
    SqlSession session2   =null;

    SqlSession session3   =null;

    SqlSession session4   =null;
    @Before
    public  void beforeMethod(){
        // 1 找到 sqlmapConfig.xml
        String name  ="SqlMapConfig.xml";
        // 实际上 要从工程角度出发，当前这个文件是在工程的相对位置 得到它的io流
        InputStream is  = TestBlogDao2.class.getClassLoader().getResourceAsStream(name);

        // 2 把它加载到 sql会话工厂中 帮你解析(给工厂 加载 了 装备（指导书）)
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3 通过会话工程 ，获得一个 sql会话
         session1   =  sessionFactory.openSession();

        session2   =  sessionFactory.openSession();

        session3   =  sessionFactory.openSession();

        session4   =  sessionFactory.openSession();
    }
    @After
    public void afterMethod(){

        // 6 关闭资源
//        session1.close();
//        session2.close();
    }


    /**
     * 二级缓存中会不会出现  代码级别  脏数据  二级缓存 是 mapper级别
     * blogMapper 中  查询 博客信息（含有用户信息）
     * userMapper 中  修改 user数据
     * blog再次查询的时候，user是新的还是旧的？？
     *
     */
   @Test
    public void testQueryAllBlog() throws InterruptedException {

       // 1 blogMapper 查询 ，然后，涉及到 user数据
       IBlogDao blogDao1 = session1.getMapper(IBlogDao.class);
       System.out.println(blogDao1.queryBlogAndUserByBlogId(1));
       session1.close();

       // 2 userMapper 增删改 ，他们是不同的mapper，所以 不用让blogMaper的二级缓存 清空
       // 4 解决方案：在UserMapper配置一个 缓存关联关系
       // <cache-ref namespace="com.gmgx.dao.IBlogDao"/>
       IUserDao userDao  =   session2.getMapper(IUserDao.class);
       userDao.modifyUserName(1,"张三三");
       session2.commit();
       session2.close();

        // 3 blogMapper再次查询的时候，得到的是“脏数据" user 的数据 是旧的,
       // 5 当然，配置完二级缓存关联关系后，就可以解决这个问题了
       IBlogDao blogDao3 = session3.getMapper(IBlogDao.class);
       System.out.println(blogDao3.queryBlogAndUserByBlogId(1));
       session3.close();


   }

}