package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class Student {

    private Integer sno;
    private String sname;

    public Student() {
        System.out.println("Student的无参构造");

    }



    //    init-method=""
    public void initMethod(){
        System.out.println("初始化Student对象");

    }
    //    destroy-method=""
    public void destroyMethod(){

        System.out.println("销毁Student对象");


    }

}
