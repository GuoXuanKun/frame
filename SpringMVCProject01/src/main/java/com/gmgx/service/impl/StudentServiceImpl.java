package com.gmgx.service.impl;

import com.gmgx.dao.StudentDao;
import com.gmgx.entity.Student;
import com.gmgx.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> queryAllStudent() {
        return studentDao.queryAllStudent();
    }
}
