package com.gmgx.service;

import com.gmgx.entity.Student;

import java.util.List;

public interface IStudentService {

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> queryAllStudent();
}
