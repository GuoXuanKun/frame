package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class Student {
    private Integer sno;
    private String sname;

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        System.out.println("setSno方法被调用");
        this.sno = sno;
    }

    public String getSname() {

        return sname;
    }

    public void setSname(String sname) {
        System.out.println("setSname方法被调用");
        this.sname = sname;
    }




    public Student() {
        System.out.println("Student的无参构造");

    }


    public Student(Integer sno, String sname) {

        System.out.println("sno 和  sname的构造方法");
        this.sno = sno;
        this.sname = sname;
    }



    public Student( String sname,Integer sno) {

        System.out.println("sname  和 sno 的构造方法");
        this.sno = sno;
        this.sname = sname;
    }







    public Student(Integer sno) {
        this.sno = sno;
    }


    public Student(String sname) {
        this.sname = sname;
    }





/*

尝试一下 有没有 什么特殊的玩法，来挑战 一下  Spring
    public Student( double arg) {

        System.out.println("（double）arg:"+arg);
    }

    public Student( char arg) {

        System.out.println("（char）arg:"+arg);
    }

    public Student( char arg1,   double arg2) {

        System.out.println("（char）arg:"+arg1);
    }
    public Student(double arg1, char arg2) {

        System.out.println("（char）arg:"+arg1);
    }
*/





    //    init-method=""
    public void initMethod(){
        System.out.println("初始化Student对象");

    }
    //    destroy-method=""
    public void destroyMethod(){

        System.out.println("销毁Student对象");


    }














    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                '}';
    }
}
