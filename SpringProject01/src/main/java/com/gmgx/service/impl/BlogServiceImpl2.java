package com.gmgx.service.impl;

import com.gmgx.dao.BlogDao;
import com.gmgx.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/* 第四种 方案（最建议的）：小括号中 写上 和 控制类中的属性名 一致的名字 */
@Service("blogService")
public class BlogServiceImpl2 implements IBlogService {
    @Autowired
    private BlogDao blogDao;

    public void login(){
        System.out.println("blog service 2  login");
        blogDao.login();

    }

}
