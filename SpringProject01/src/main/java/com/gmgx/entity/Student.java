package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


public class Student {

    private Integer sno;
    private String sname;

    private  Integer[] scoreArr;

    private List<String> addrList;

    private Map<Integer,String> phoneMap;

    public Student(Map<Integer, String> phoneMap) {
        this.phoneMap = phoneMap;
    }

    public Map<Integer, String> getPhoneMap() {
        return phoneMap;
    }


    public void setPhoneMap(Map<Integer, String> phoneMap) {
        this.phoneMap = phoneMap;
    }

    public List<String> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<String> addrList) {
        this.addrList = addrList;
    }

    public Student(List<String> addrList) {
        this.addrList = addrList;
    }

    public Student(Integer[] scoreArr) {
        this.scoreArr = scoreArr;
    }

    public Integer[] getScoreArr() {
        return scoreArr;
    }

    public void setScoreArr(Integer[] scoreArr) {
        this.scoreArr = scoreArr;
    }

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
