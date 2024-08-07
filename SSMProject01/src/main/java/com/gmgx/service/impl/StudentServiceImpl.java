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
    private IStudentDao iStudentDao;
    @Override
    public List<Student> queryAllStudent() {
        return iStudentDao.queryAllStudent();
    }
}
