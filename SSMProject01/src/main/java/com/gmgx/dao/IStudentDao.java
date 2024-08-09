package com.gmgx.dao;

import com.gmgx.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentDao {

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> queryAllStudent();

    public Student queryStudentBySno(Integer sno);

    public boolean modifyStudent(Student stu);

    public boolean   deleteStudentBySno(@Param("sno") Integer sno);
    public boolean addStudent(Student stu);

}
