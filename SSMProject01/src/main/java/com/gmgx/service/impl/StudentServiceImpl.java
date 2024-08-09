package com.gmgx.service.impl;

import com.gmgx.dao.IStudentDao;
import com.gmgx.entity.Student;
import com.gmgx.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;
    @Override
    public List<Student> queryAllStudent() {
        return studentDao.queryAllStudent();
    }


    @Override
    public Student queryStudentBySno(Integer sno) {
        return studentDao.queryStudentBySno(sno);
    }

    @Override
    public boolean modifyStudent(Student stu) {
        return studentDao.modifyStudent(stu);
    }

    @Override
    public boolean deleteStudentBySno(Integer sno) {
        return studentDao.deleteStudentBySno(sno);
    }

    @Override
    public boolean addStudent(Student stu) {
        return studentDao.addStudent(stu);
    }
}
