package com.gmgx.controller;

import com.gmgx.entity.Student;
import com.gmgx.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private IStudentService studentService;




    @RequestMapping("login")
    public String login(String username,String password){

        System.out.println("username:"+username);
        System.out.println("password:"+password);

        return  "main"; //经过视图解析器 ，拼接成 /main.jsp
        // req.getRequestDispatcher("main.jsp").forward(req,resp);
    }

    @RequestMapping("queryStudentBySno")
    public ModelAndView queryStudentBySno(Integer sno){
        ModelAndView  mv   = new ModelAndView();
        System.out.println("sno:"+sno);
        Student student  = new Student();
        student.setSno(sno);
        student.setSname("zhw");
        //  存数据（默认存在request范围）
        mv.addObject("stu",student);
        // 跳转的页面（默认 转发）
        mv.setViewName("queryStudentBySno");

        return  mv;
        // 前置控制器，得到mv对象，解析它，
        //mv.getView() 得到 路径（queryStudentBySno），经过视图解析器 ，拼接成 /queryStudentBySno.jsp
        // mv.getModel() 获得 数据（相当于 从 request.getAttribute("")中获得数据一样）
        //将这些数据 设置到 对应的jsp页面中
        // req.getRequestDispatcher("main.jsp").forward(req,resp);
    }

    @RequestMapping("queryAllStudent")
    public ModelAndView queryAllStudent(){
        ModelAndView mv   = new ModelAndView();

        List<Student> list   = studentService.queryAllStudent();
        mv.addObject("slist",list);
        mv.setViewName("queryAllStudent");
        return  mv;
    }



}
