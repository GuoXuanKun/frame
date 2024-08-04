package com.gmgx.service;

import com.gmgx.dao.TeacherDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherService {
@Resource
    private TeacherDao teacherDao;




    public TeacherService() {

        System.out.println("TeacherService的无参构造");
    }

    public boolean login(String username, String password){
       return teacherDao.login(username,password);

    }


}
