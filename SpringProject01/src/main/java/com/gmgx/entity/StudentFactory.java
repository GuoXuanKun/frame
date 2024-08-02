package com.gmgx.entity;

public class StudentFactory {

    public static Student createStudent(){
        //  假装 做了一些 配置动作
         return  new Student();

    }


    public  Student createStudent2(){
        //  假装 做了一些 配置动作
        return  new Student();

    }

    public void setConfig(){

        System.out.println("假装 是一些 配置 信息");


    }


}
