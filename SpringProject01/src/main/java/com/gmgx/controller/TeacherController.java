package com.gmgx.controller;

import com.gmgx.service.TeacherService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/*
 * 如果是控制层：使用 @Controller注解 来表示
 * */
@Controller
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    public boolean login(String username, String password){
        return teacherService.login(username,password);

    }

    public TeacherController() {

        System.out.println("TeacherController的无参构造");
    }
}
