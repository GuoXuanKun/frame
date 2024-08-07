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




}
