package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private  Integer sno;
    private  String sname;
    private  String password;
    private String photo;// 头像地址
    private String resume;// 简历（地址）
}
