package com.gmgx.controller;

import com.gmgx.entity.Student;
import com.gmgx.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    //报错 405 ：方法不允许  Request method 'GET' not supported
    @RequestMapping(value = "register",method = RequestMethod.POST )
//    public ModelAndView regisger(Student student, HttpServletRequest request){
//    public ModelAndView regisger(Student student, HttpSession session){
    public ModelAndView regisger(Student student){
        System.out.println(student);
        ModelAndView mv  = new ModelAndView();
        boolean flag  =  studentService.register(student);

        if(flag){
            mv.addObject("msg","注册成功，您的学号为："+student.getSno());
            // 默认是 特殊 转发 （经过前置控制器的转发到指定的jsp页面）
            // mv.setViewName("main");
            /* 不会经过 视图解析器   */
            /* 把数据放在 session 中  */
//           request.getSession().setAttribute("msg","注册成功，您的学号为："+student.getSno());
            //     session.setAttribute("msg","注册成功，您的学号为："+student.getSno());

            mv.setViewName("redirect:../main.jsp");


        }else{
            mv.addObject("msg","注册失败");
            mv.setViewName("register");
        }

        return  mv;







    }





    @RequestMapping("login")
    public ModelAndView login(int sno,String password){
        System.out.println("login方法");
        List<Student> students = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView();
        if (students!= null){
            modelAndView.addObject("msg",students.get(0));
            modelAndView.setViewName("redirect:../main.jsp");
        }else {
            modelAndView.addObject("msg","登录失败");
            modelAndView.setViewName("redirect:../login.jsp");
        }
        return modelAndView;
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


//    @RequestMapping("register")
//    public ModelAndView register(Student student){
//
//
//        System.out.println("register:stu=" +student);
//
//
//        ModelAndView mv   = new   ModelAndView();
//        // 相当于request.setAttribute();
//        mv.addObject("msg","成功");
//        /* jsp 文件名 （不用后缀）  */
//        mv.setViewName("main");
//
//        return mv;
//    }

}
