package com.gmgx.dao;

import com.gmgx.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentDao {

   IStudentDao  studentDao  = null;
    @Before
    public void beforeMethod(){

        String path  ="applicationContext.xml";
        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext(path);
         studentDao  =    applicationContext.getBean(IStudentDao.class);
    }



    @Test
    public void testQueryAllStudent(){


       // System.out.println(studentDao.queryAllStudent());

//        System.out.println(studentDao.queryStudentBySno(1));
//        System.out.println(studentDao.deleteStudentBySno(693));
//        System.out.println(studentDao.modifyStudent(new Student(1,null,"888")));
      Student stu  =   new Student(null,"马云","888");
        System.out.println(studentDao.addStudent(stu));
        System.out.println(stu.getSno());

    }




}
