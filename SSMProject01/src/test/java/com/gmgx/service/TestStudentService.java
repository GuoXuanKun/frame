package com.gmgx.service;

import com.gmgx.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentService {


    @Test
    public void test01(){

        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService studentService  =  applicationContext.getBean(IStudentService.class);
        System.out.println(studentService.queryAllStudent());
        System.out.println(studentService.queryStudentBySno(1));
        System.out.println(studentService.addStudent(new Student(null,"zhw","123")));
    }


    @Test
    public void test02(){

        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
        ITeacherService teacherService  =  applicationContext.getBean(ITeacherService.class);
        System.out.println(teacherService.queryAllStudent());
//        System.out.println(studentService.queryStudentBySno(1));
//        System.out.println(studentService.addStudent(new Student(null,"zhw","123")));
    }


    @Test
    public void test03(){

        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestAopService testAopService  =  applicationContext.getBean(TestAopService.class);
        System.out.println(testAopService.login());
//        System.out.println(studentService.queryStudentBySno(1));
//        System.out.println(studentService.addStudent(new Student(null,"zhw","123")));
    }


}
