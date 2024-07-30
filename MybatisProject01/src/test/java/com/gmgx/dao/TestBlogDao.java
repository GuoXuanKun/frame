package com.gmgx.dao;

import com.gmgx.entity.Blog;
import com.gmgx.entity.User;
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


    /** 默认开启一级缓存  会话 session级别
     *  在同一个 session 对象，产生 同一个 dao对象，执行两次同一个方法（查询全部） ，第一次 会从数据库获取，第二次 直接从缓存中获取数据
     *  不同的 session 对象（s1 和 s2），产生 产生2个 dao对象（同类型 IBlogDao），分别执相同的方法（查询全部），
     *   这种情况下，不会用到缓存  （一级缓存是session级别，不同的session对象不会共享缓存）
     */
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

    /**
     * 同一个session对象，产生的两个 相同类型的dao对象，执行相同方法，也是会用到缓存数据
     * 一级缓存，就是session级别，也就是同一个session会共享数据（前提是在相同dao类型执行相同方法）
     */
    @Test
    public void testQueryAllBlog2(){

        IBlogDao blogDao1  =  session1.getMapper(IBlogDao.class);
        IBlogDao blogDao2  =  session1.getMapper(IBlogDao.class);
        System.out.println(blogDao1==blogDao2);//false 独立的两个对象

        System.out.println(blogDao1.queryAllBlog());
        System.out.println("=======");
        System.out.println(blogDao2.queryAllBlog());


    }

    /**
     * 同一个的session，同一个dao对象，执行的不同的方法，但是查询数据一样（sql语句是一样的），这种情况下，
     * 不会用到缓存（  mybatis 只认准 类 和 方法  ）
     */
    @Test
    public void testQueryAllBlog3(){

        IBlogDao blogDao  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao.queryAllBlog());
        System.out.println("=======");
        System.out.println(blogDao.queryAllBlog2());


    }


    /**
     * 同一个的session 同一个dao对象，同一个方法，相同的参数 ，也是会有用到 缓存
     * 参数不同值， 肯定会  再 查一次（执行一次查询）
     */
    @Test
    public void testQueryBlogById(){

        IBlogDao blogDao  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao.queryBlogById(1));
        System.out.println("=======");
        System.out.println(blogDao.queryBlogById(2));


    }

    /**
     * 特殊情况：不建议写的（涉及到魔术代码 把最终参数 或 数据 写死了）
     * 同一个的session 同一个dao对象，
     * 同一个方法，参数不同值， 但是 我们把sql语句写死了， 最终的sql语句（即将要传到数据库去执行语句） 一样的，mybatis会去判断，有没有必要再查一次
     会缓存拿
     */
    @Test
    public void testQueryBlogById2(){

        IBlogDao blogDao  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao.queryBlogById2(1));
        System.out.println("=======");
        System.out.println(blogDao.queryBlogById2(2));


    }

    @Test
    public void testQueryBlogById3(){

        IBlogDao blogDao  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao.queryBlogById3(1,2));
        System.out.println("=======");
        System.out.println(blogDao.queryBlogById3(2,1));


    }
    @Test
    public void testQueryBlogById4(){

        IBlogDao blogDao  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao.queryBlogById4(1,2));
        System.out.println("=======");
        System.out.println(blogDao.queryBlogById4(2,1));


    }


    /**
     *实现手动清除缓存
     *
     */

    @Test
    public void testQueryAllBlog5(){

        IBlogDao blogDao  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao.queryAllBlog());
        // 手动清除数据
        session1.clearCache();

        System.out.println("=======");
        System.out.println(blogDao.queryAllBlog());


    }

    /**
     * 被动清除  同一个session 中途 实现 增删改 操作
     */
    @Test
    public void testQueryAllBlog6(){

        IBlogDao blogDao  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao.queryAllBlog());


        System.out.println(blogDao.modifyBlog(new Blog(1, "今天天气不错", "大师兄说得对", 1)));

        System.out.println("=======");
        System.out.println(blogDao.queryAllBlog());


    }


    /**
     * 被动清除  同一个session 中途 实现 增删改 操作,
     * 即使 我们查到的数据 和改的数据不是同一个数据，都会清空（实际上，是只要有增删改，整个 session 的缓存 都会清空掉）
     */
    @Test
    public void testQueryAllBlog7(){

        IBlogDao blogDao  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao.queryBlogById(1));


        System.out.println(blogDao.modifyBlog(new Blog(2, "今天天气不错2222", "大师兄说得对222", 1)));
        session1.commit();
        System.out.println("=======");

        System.out.println(blogDao.queryBlogById(1));


    }

    /*
    只要是 同一个session，无论是 增删改 任何的表（只要是增删改动作），session缓存都会清空
     */
    @Test
    public void testQueryAllBlog8(){

        IBlogDao blogDao  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao.queryBlogById(1));

        //  修改的是别的表
        System.out.println(blogDao.modifyUser(new User(2, null, "666")));
        session1.commit();
        System.out.println("=======");

        System.out.println(blogDao.queryBlogById(1));


    }


    /*
        不同的session，就不会引起清除：
        s1 查询
        s2 增删改
        s1 再查询（旧数据，没有从数据库中获取新数据，而是从缓存中获得的旧数据 ：这种数据我们称为 脏数据 ）
  */
    @Test
    public void testQueryAllBlog9(){

        IBlogDao blogDao1  =  session1.getMapper(IBlogDao.class);


        System.out.println(blogDao1.queryBlogById(1));
        // 没修改前：session1查到数据：Blog(blogId=1, blogTitle=我是刘德华 演唱会, blogContent=呵呵呵, userId=1)

        // 通过不同的session对象，产生了一个新的dao对象
        IBlogDao blogDao2  =  session2.getMapper(IBlogDao.class);
        //  session2 来做修改：
        System.out.println(blogDao2.modifyBlog(new Blog(1, "有点冷", "大师兄说得对对对对", 1)));


        session2.commit();
        System.out.println("=======");

        System.out.println(blogDao1.queryBlogById(1));
        // 修改后：session1查到数据：
        //Blog(blogId=1, blogTitle=我是刘德华 演唱会, blogContent=呵呵呵, userId=1)
        // 旧数据 就是我们常提的 “脏数据”

    }


}