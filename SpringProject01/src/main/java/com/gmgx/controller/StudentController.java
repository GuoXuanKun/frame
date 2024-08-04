package com.gmgx.controller;

import com.gmgx.service.StudentService;


public class StudentController {


    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentController() {

        System.out.println("StudentController的无参构造");
    }



    public boolean login(String username,String password){
        return studentService.login(username,password);

    }

    public boolean login2(String username,String password){
        return studentService.login(username,password);

    }

}
