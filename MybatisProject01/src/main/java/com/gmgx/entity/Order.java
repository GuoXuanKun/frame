package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Integer orderId;
    private double orderPrice;
    private String orderAddr;
    private Date orderDate;
    private Integer userId;

    private User orderUser;

}
