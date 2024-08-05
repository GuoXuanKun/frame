package com.gmgx.controller;

import com.gmgx.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("student")
public class StudentController {
    @RequestMapping("login")
    public void login(){

        System.out.println("login方法");
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
    @RequestMapping("queryStudentBySno")
    public ModelAndView queryStudentBySname(Integer  sno){


        System.out.println("queryStudentBySname:sno=" +sno);


        ModelAndView mv   = new   ModelAndView();
        // 相当于request.setAttribute();
        mv.addObject("sname","zhw");
        /* jsp 文件名 （不用后缀）  */
        mv.setViewName("queryStudentBySno");

        return mv;
    }


    @RequestMapping("register")
    public ModelAndView register(Student student){


        System.out.println("register:stu=" +student);


        ModelAndView mv   = new   ModelAndView();
        // 相当于request.setAttribute();
        mv.addObject("msg","成功");
        /* jsp 文件名 （不用后缀）  */
        mv.setViewName("main");

        return mv;
    }

}
