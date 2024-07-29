package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer userId;
    private String userName;
    private String userPwd;
    private String userAddr;
    private List<Order> orderList;

}