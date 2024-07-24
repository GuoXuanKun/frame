package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer sno;
    private String sname;
    private String password;
    private String sex;
    private Integer age;
    private Date birthday;



}
