package com.gmgx.service.impl;

import com.gmgx.dao.BlogDao;
import com.gmgx.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogDao blogDao;

    public void login(){
        System.out.println("blog service  login");
        blogDao.login();

    }

}
