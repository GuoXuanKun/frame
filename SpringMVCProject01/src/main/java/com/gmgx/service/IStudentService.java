package com.gmgx.service;

import com.gmgx.entity.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> queryAllStudent();

    public boolean register(Student student);

    /**
     * 学生 登录
     * @param sno
     * @param password
     * @return
     */
    public List<Student> login(int sno,String password);
}
