package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private Integer aid;
    private  String name; // 收件人名字
    private String phone;// 收件人手机号
    private String addr;//具体地址

}
