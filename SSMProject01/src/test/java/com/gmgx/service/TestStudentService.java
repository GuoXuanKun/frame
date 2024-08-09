package com.gmgx.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentService {


    @Test
    public void test01(){

        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService studentService  =  applicationContext.getBean(IStudentService.class);
        System.out.println(studentService.queryAllStudent());
//        System.out.println(studentService.queryStudentBySno(1));
//        System.out.println(studentService.addStudent(new Student(null,"zhw","123")));
    }
}
