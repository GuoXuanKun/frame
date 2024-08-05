package com.gmgx.controller;

import com.gmgx.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BlogController {

    /* 第一种情况： 当 接口对应的实现类 有且仅有一个，直接@Autowired 就可以 识别了，名字对不上也没关系  */
//    @Autowired
//    private IBlogService blogService;

    /*第二种情况： 当 接口对应的实现类 有多个实现类，直接@Autowired ，需要属性名是 指定实现类的类名首字母小写  */
//    @Autowired
//    private IBlogService blogServiceImpl2;

    /*第三种情况： 当 接口对应的实现类 有多个实现类，直接@Autowired ，使用 注解@Qualifier("指定实现类类名首字母小写")  属性名随便取了  */
//    @Autowired
//    @Qualifier("blogServiceImpl2")
//    private IBlogService blogService;


    /*第四种情况： 当 接口对应的实现类 有多个实现类，直接@Autowired ，不需要做其他变动，在对应要注入的属性的的实现类的注解后，加上 括号（和本类中的属性名一致）      */
    @Autowired
    private IBlogService blogService;
    public  void login(){
        System.out.println("blog controller login");
        /* 第一种情况*/
//        blogService.login();

        /* 第二种情况*/
//        blogServiceImpl2.login();

        /* 第三种情况*/
        blogService.login();

    }




}
