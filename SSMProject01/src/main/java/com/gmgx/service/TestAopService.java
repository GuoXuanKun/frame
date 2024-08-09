package com.gmgx.service;

import org.springframework.stereotype.Service;

@Service
public class TestAopService {


    public  String  login(){

        System.out.println("我准备登录le 。。。。");
       // int i =1/0;
        return "我做到了~~~";
    }

    public  boolean  addMsg(String msg){

        System.out.println("添加数据"+msg);
//        int i =1/0;
        return true;
    }


}
