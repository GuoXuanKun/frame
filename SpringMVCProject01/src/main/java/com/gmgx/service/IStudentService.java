package com.gmgx.service;

import com.gmgx.entity.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> queryAllStudent();

    public boolean register(Student student);
    public boolean deleteStudent(Integer sno);


    public boolean  modifyStudent(Student student);


    public Student  queryStudentBySno(Integer sno);

    public boolean modifyStudentPhoto(Integer sno,String photo);

    public boolean modifyStudentResume(Integer sno,String resume);

}
