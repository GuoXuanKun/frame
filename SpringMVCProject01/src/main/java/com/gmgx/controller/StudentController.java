package com.gmgx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {

    @RequestMapping("login")
    public void login(){
        System.out.println("login");
    }

    @RequestMapping("login2")
    public String login2(){

        System.out.println("login方法");
        return "main";
    }

    @RequestMapping("queryStudentBySname")
    public String queryStudentBySname(String  sname){

        System.out.println("queryStudentBySname:sname=" +sname);

        return "main";
    }
}
