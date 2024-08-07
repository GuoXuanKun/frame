package com.gmgx.dao;

import com.gmgx.entity.Student;

import java.util.List;

public interface IStudentDao {

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> queryAllStudent();

}
