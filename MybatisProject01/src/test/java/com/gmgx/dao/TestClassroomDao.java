package com.gmgx.dao;

import com.gmgx.dto.ClassroomDto;
import com.gmgx.entity.Classroom;
import com.gmgx.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestClassroomDao {
    SqlSession session   =null;
    IClassroomDao classroomDao =null;

    @Before
    public  void beforeMethod(){
        // 1 找到 sqlmapConfig.xml
        String name  ="SqlMapConfig.xml";
        // 实际上 要从工程角度出发，当前这个文件是在工程的相对位置 得到它的io流
        InputStream is  = TestClassroomDao.class.getClassLoader().getResourceAsStream(name);

        // 2 把它加载到 sql会话工厂中 帮你解析(给工厂 加载 了 装备（指导书）)
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3 通过会话工程 ，获得一个 sql会话
        session   =  sessionFactory.openSession();

        classroomDao  =  session.getMapper(IClassroomDao.class);
    }
    @After
    public void afterMethod(){

        // 6 关闭资源
        session.close();

    }

    @Test
    public void testQueryAllClassroomAndStudent(){

        List<ClassroomDto> list  = classroomDao.queryAllClassroomAndStudent();
        for (ClassroomDto c:list){
            System.out.println(c);
        }

    }



    @Test
    public void testQueryAllClassroomAndStudent2(){

        List<Classroom> list  = classroomDao.queryAllClassroomAndStudent2();
        for (Classroom c:list){
            System.out.println(c);
            for (Student stu:c.getMyStuList()){
                System.out.println("    ----"+stu);
            }

        }

    }
}
