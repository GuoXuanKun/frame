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
        System.out.println("假装已经登录了");
        mv.addObject("my","zhw");
        mv.setViewName("redirect:queryAllStudent");
        return  mv;
    }



    @RequestMapping("queryAllStudent")
    public ModelAndView queryAllStudent(){
        ModelAndView mv = new ModelAndView();
        List<Student> slist = studentService.queryAllStudent();
        mv.addObject("slist",slist);
        mv.setViewName("student/queryAllStudent");
        return  mv;
    }

    @RequestMapping("queryStudentBySno")
    public ModelAndView queryStudentBySno(Integer sno){
        ModelAndView mv   = new ModelAndView();
        Student student  =  studentService.queryStudentBySno(sno);
        mv.addObject("student",student);
        mv.setViewName("student/queryStudentBySno");
        return  mv;
    }




    @RequestMapping("modifyStudent")
    public ModelAndView modifyStudent(Student student){
        ModelAndView mv   = new ModelAndView();
        boolean flag  =  studentService.modifyStudent(student);
        mv.addObject("msg",flag);
        mv.setViewName("redirect:queryStudentBySno?sno="+student.getSno());
        return  mv;
    }


    @RequestMapping("deleteStudentBySno")
    public ModelAndView deleteStudentBySno(Integer sno){
        ModelAndView mv   = new ModelAndView();
        boolean flag  =  studentService.deleteStudentBySno(sno);
        mv.addObject("msg",flag);
        mv.setViewName("redirect:queryAllStudent");
        return  mv;
    }


    @RequestMapping("addStudent")
    public ModelAndView addStudent(Student student){
        ModelAndView mv   = new ModelAndView();
        boolean flag  =  studentService.addStudent(student);
        mv.addObject("msg",flag);
        mv.setViewName("redirect:queryStudentBySno?sno="+student.getSno());
        return  mv;
    }




}
