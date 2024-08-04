package com.gmgx.service.impl;

import com.gmgx.dao.ClassroomDao;
import com.gmgx.service.IClassroomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("classroomService")
public class ClassroomServiceImpl2 implements IClassroomService {

    @Resource
    private ClassroomDao classroomDao;

    @Override
    public boolean login(String username, String password) {
        return classroomDao.login(username,password);
    }

    public ClassroomServiceImpl2() {

        System.out.println("ClassroomServiceImpl 第二版");
    }
}
