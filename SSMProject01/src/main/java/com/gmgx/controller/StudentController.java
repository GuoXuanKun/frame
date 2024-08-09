package com.gmgx.controller;

import com.gmgx.entity.Student;
import com.gmgx.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("student")
@SessionAttributes({"msg","my"})
public class StudentController {

    @Autowired
    private IStudentService studentService;


    @RequestMapping("login")
    public ModelAndView login(){
        ModelAndView mv   = new ModelAndView();
        mv.addObject("my","zhw");
        return  mv;
    }



    @RequestMapping("queryAllStudent")
    public ModelAndView queryAllStudent(){
        ModelAndView mv = new ModelAndView();
        List<Student> slist = studentService.queryAllStudent();
        mv.addObject("slist",slist);
        mv.setViewName("queryAllStudent");

        return mv;
    }
}
