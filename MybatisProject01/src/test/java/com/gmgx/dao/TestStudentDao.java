package com.gmgx.dao;

import com.gmgx.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class TestStudentDao {

    SqlSession session;
    IStudentDao studentDao;
    @Before
    public void before(){
        // 1 找到 sqlmapConfig.xml
        String name  ="SqlMapConfig.xml";
        // 实际上 要从工程角度出发，当前这个文件是在工程的相对位置 得到它的io流
        InputStream is  = TestStudentDao.class.getClassLoader().getResourceAsStream(name);

        // 2 把它加载到 sql会话工厂中 帮你解析(给工厂 加载 了 装备（指导书）)
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3 通过会话工程 ，获得一个 sql会话
        session   =  sessionFactory.openSession();

        // 4 通过会话 得到 dao层接口的 实现 对象，执行方法
        studentDao = session.getMapper(IStudentDao.class);

    }
    @After
    public void after(){
        // 6 关闭资源
        session.close();
    }

    @Test
    public void testQueryAllStudent(){
        // 4 通过会话 得到 dao层接口的 实现 对象，执行方法
        IStudentDao studentDao = session.getMapper(IStudentDao.class);
        List<Student> list  =  studentDao.queryAllStudent();
        // 5 处理结果
        for (Student stu:list){
            System.out.println(stu);
        }

    }



    @Test
    public void testQueryStudentBySno(){


        Student student =  studentDao.queryStudentBySno(5);
        // 5 处理结果
            System.out.println(student);
    }

    @Test
    public void testupdateStudentAge(){
        Student student = new Student();
        student.setSno(5);
        student.setAge(1000);
        studentDao.updateStudentAge(student);
        // 5 处理结果
        session.commit();
    }

    @Test
    public void testQueryStudentByLikeSname(){
        System.out.println(studentDao.queryStudentByLikeSname("李"));
    }

    @Test
    public void testQueryStudentByPage(){
       List<Student> list = studentDao.queryStudentByPage(5,5);
       for(Student stu : list){
           System.out.println(stu);
       }
    }

    @Test
    public void testQuetyStudentByOrder(){
        List<Student> list = studentDao.queryStudentByOrder("age","desc");
        for(Student stu : list){
            System.out.println(stu);
        }
    }
}
