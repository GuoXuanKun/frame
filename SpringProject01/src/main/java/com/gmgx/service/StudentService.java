package com.gmgx.service;

import com.gmgx.dao.StudentDao;


public class StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    public StudentService() {

        System.out.println("StudentService的无参构造");
    }

    public boolean login(String username, String password){
       return studentDao.login(username,password);

      //  return true;
    }


}
