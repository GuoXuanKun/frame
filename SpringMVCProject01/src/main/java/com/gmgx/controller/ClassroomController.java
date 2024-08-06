package com.gmgx.controller;

import com.gmgx.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("classroom")
public class ClassroomController {

    /* dataType : text 中文乱码：解决方案：在 RequestMapping 加上
    produces = "text/html;charset=UTF-8"
* */
@RequestMapping(value = "queryCnameByCno",produces = "text/html;charset=UTF-8")
@ResponseBody
/* 加入 ResponseBody 响应体  返回的数据，不再是 jsp页面路径 而是 响应数据  */
public String queryCnameByCno(Integer cno){

    System.out.println("queryCnameByCno 被调用");

    return cno+"班级";

}


    @RequestMapping(value = "queryStudentByCno")
    @ResponseBody
    public Student queryStudentByCno(Integer cno){

        System.out.println("queryStudentByCno 被调用：cno="+cno);
        Student student  = new Student();
        student.setSno(1);
        student.setSname("庄宏伟");

        //  原来需要自己去做 通过 json类中方法  转换 对象 转换成 json格式
        // 现在这个动作也不用你做了
        // SpringMVC 来实现
        // 提前做两个准备：
        // 1 引入jar包：jackson 的两个jar包
        // 2

        return student;
    }

    @RequestMapping(value = "queryAllStudent")
    @ResponseBody
    public List<Student> queryAllStudent(){

        System.out.println("queryAllStudent");

        List<Student> slist  = new ArrayList<>();

        Student student1  = new Student();
        student1.setSno(1);
        student1.setSname("庄宏伟");

        slist.add(student1);


        Student student2  = new Student();
        student2.setSno(2);
        student2.setSname("庄宏伟2");

        slist.add(student2);



        return slist;
    }

}
