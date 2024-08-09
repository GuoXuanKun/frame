package com.gmgx.controller;

import com.gmgx.entity.Student;
import com.gmgx.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("ajaxStudent")
public class AjaxStudentContrller {

    @Autowired
    private IStudentService studentService;


    @RequestMapping("queryAllStudent")
    @ResponseBody
    public List<Student> queryAllStudent(){

       return  studentService.queryAllStudent();

    }

/* ,produces = "text/html;charset=UTF-8" 如果传递非text 不要加  */
    @RequestMapping(value = "deleteStudent")
    @ResponseBody
    public Boolean  deleteStudent(Integer sno){

        return  studentService.deleteStudent(sno);
    }


    @RequestMapping(value = "addStudent")
    @ResponseBody
    public Integer  addStudent(Student stu){
        studentService.register(stu);
        // 得到 一个 自增 地址 id值 赋值给 stu的sno属性
        return  stu.getSno();

    }



    @RequestMapping(value = "queryStudentBySno")
    public ModelAndView queryStudentBySno(Integer sno){
        ModelAndView mv   = new ModelAndView();

      Student  student  =   studentService.queryStudentBySno(sno);

        mv.addObject("student",student);

        mv.setViewName("ajaxStudent/modifyStudent");
        // 得到 一个 自增 地址 id值 赋值给 stu的sno属性
        return mv;

    }


    @RequestMapping(value = "modifyStudent")
    @ResponseBody
    public Boolean modifyStudent(Student stu){
        return  studentService.modifyStudent(stu);



    }




}
