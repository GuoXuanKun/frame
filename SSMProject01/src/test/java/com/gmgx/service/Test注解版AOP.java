package com.gmgx.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test注解版AOP {


    @Test
    public void test01(){

        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("applicationContext_注解版AOP.xml");
        IStudentService studentService  =  applicationContext.getBean(IStudentService.class);
        System.out.println(studentService.queryAllStudent());
//        System.out.println(studentService.queryStudentBySno(1));
//        System.out.println(studentService.addStudent(new Student(null,"zhw","123")));
    }

    @Test
    public void test02(){

        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("applicationContext_注解版AOP.xml");
        ITeacherService teacherService  =  applicationContext.getBean(ITeacherService.class);
        System.out.println(teacherService.queryAllStudent());
//        System.out.println(studentService.queryStudentBySno(1));
//        System.out.println(studentService.addStudent(new Student(null,"zhw","123")));
    }

}

